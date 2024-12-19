import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final int port = 12345;
    private final Map<Integer, Philosopher> philosWithId = new ConcurrentHashMap<>();
    private final Fork[] forks;

    public Server(int qtdForks){
        this.forks = new Fork[qtdForks];
        for (int i=0; i<qtdForks; i++){
            forks[i] = new Fork();
        }
    }

    public void start() throws IOException{
        System.out.println("Philosopher Dinner has begin...");
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client connected: " + client.getInetAddress());
                new Thread (new PhilosopherHelper(client, philosWithId, forks)).start();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
