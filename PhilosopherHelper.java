import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class PhilosopherHelper implements Runnable{
    private final Socket socket;
    private final Map<Integer, Philosopher> philos;
    private final Fork[] forks;
    private Philosopher philosopher;
    private static int philosopherCounter = 0;

    public PhilosopherHelper(Socket socket, Map<Integer, Philosopher>philos, Fork[] forks){
        this.socket = socket;
        this.philos = philos;
        this.forks = forks;
    }

    @Override
    public void run() {
       try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ){
            String input;
            while ((input = in.readLine()) != null) {
                // System.out.println("Received: " + input);
                String[] text = input.split(" ");
                String firstPart = text[0];
                System.out.println(firstPart);

                switch (firstPart) {
                    case "HELLO":
                        // out.println(firstPart);
                        // System.out.println(firstPart);
                        setPhilosopher(out);
                        break;
                
                    // case "THINK":
                    //     showThinks(out);
                    //     break;
                    
                    case "PICK_FORKS":
                        helperForkPickUp(out);
                        break;

                    case "PICKDOWN_FORKS":
                        pickDownForks(out);
                        break;

                    case "STATUS":
                        sendStatus(out);
                        break;   

                    default:
                        // out.println(firstPart);
                        out.println("Unknown Command");
                        break;
                }
            }
        
       } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void setPhilosopher(PrintWriter out){
        synchronized(this.philos){
            philosopherCounter++;
            this.philosopher = new Philosopher(philosopherCounter);
            this.philos.put(philosopherCounter, this.philosopher);
            out.println("HELLO " + this.philosopher.getId());
        }
    }

    private void showThinks(PrintWriter out){
        this.philosopher.think();
        out.println("Philo " + this.philosopher.getId() + " THINKING");
    }

    private void helperForkPickUp(PrintWriter out){
        int leftForkPosition = this.philosopher.getId() -1;
        int rightForkPosition = this.philosopher.getId() % forks.length;

        try{
            this.forks[leftForkPosition].pickup(leftForkPosition);
            this.forks[rightForkPosition].pickup(rightForkPosition);
            this.philosopher.eat();
            out.println("Philo " + this.philosopher.getId() + " EATE");
        } catch(InterruptedException e){
            out.println("Error");
        }
    }

    private void pickDownForks(PrintWriter out){
        int leftForkPosition = this.philosopher.getId() -1;
        int rightForkPosition = this.philosopher.getId() % forks.length;
        
        this.forks[leftForkPosition].pickdown();
        this.forks[rightForkPosition].pickdown();
        out.println("PHILO " + this.philosopher.getId() + " PICKDOWN FORKS");
        showThinks(out);

    }

    private void sendStatus(PrintWriter out){
        out.println("PHILO " + this.philosopher.getId() + ": Meals " + this.philosopher.getMeals() + ", Thoughts: " + this.philosopher.getThoughts());
    }
}
