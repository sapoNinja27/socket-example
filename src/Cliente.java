import java.io.*;
import java.net.*;

public class Cliente implements Runnable{

    @Override
    public void run() {
        try{
            start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private void start() throws IOException {
        Socket socket = new Socket("localhost", 1025);
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println("Mensagem enviada ao server");

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message = bufferedReader.readLine();
        System.out.println(message);
    }

}