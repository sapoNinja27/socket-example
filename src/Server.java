import java.io.*;
import java.net.*;

public class Server implements Runnable{

    public void serve(int porte) throws IOException {
        int port = 1025 + porte;
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
            if(porte == 0){
                serve(1);
            } else {
                serve(0);
            }
        }
    }
    public void run() {
        try{
            serve(0);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}