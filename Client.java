import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client {
    private static final String host = "localhost";
    private static final int port = 12345;

    public void start(){
        try (
            Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ){
            out.println("HELLO");
            String resp = in.readLine();
            System.out.println(resp);
            Random random = new Random();
            while (true) {
                // out.println("HELLO");
                
                // out.println("THINK");
                // System.out.println(in.readLine());
                
                out.println("PICK_FORKS");
                System.out.println(in.readLine());
                
                out.println("PICKDOWN_FORKS");
                System.out.println(in.readLine());
                
                out.println("STATUS");
                System.out.println(in.readLine());
                
                int thinkTime = Math.max(0, (int) (random.nextGaussian() * 2 + 5)* 1000); //nextGaussian gera numeros pseudo-aleatorios que seguem uma distribuicao normal com 2 de desvio padrao e 5 de media.
                // System.out.println("Thinking for " + thinkTime + " ms");
                // out.println("THINK");
                System.out.println(in.readLine());
                Thread.sleep(thinkTime);
           
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
