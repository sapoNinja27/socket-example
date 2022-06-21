import java.io.*;
import java.net.*;

public class Cliente implements Runnable{

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Thread t2 = new Thread(cliente);
        t2.start();
    }

    @Override
    public void run() {
        try{
            start(0);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private void start(int porte) throws IOException {
        int port = 1025 + porte;
        Socket socket = new Socket("localhost", port);
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Digite sua mensagem: ");
        printStream.println(reader.readLine());

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message = bufferedReader.readLine();
        System.out.println(message);
        if(porte == 0){
            start(1);
        } else {
            start(0);
        }
    }

}