import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equalsIgnoreCase("server")){
            try {
                Server server = new Server(5);
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            Client client = new Client();
            client.start();
        }
    }
}
