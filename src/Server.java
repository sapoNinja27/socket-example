import java.io.*;
import java.net.*;

public class Server implements Runnable{
    public void serve() throws IOException {
        int port = 1025;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        System.out.println("Server up na porta: " + port);

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String message = bufferedReader.readLine();
        System.out.println(message);

        if(message != null) {
            PrintStream printStrea = new PrintStream(socket.getOutputStream());
            printStrea.println("Mensagem recebida");
        }
    }
    public void run() {
        try{
            serve();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}