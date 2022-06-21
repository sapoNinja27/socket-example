public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Cliente cliente = new Cliente();
        Thread t1 = new Thread(server);
        Thread t2 = new Thread(cliente);
        t1.start();
        t2.start();
    }
}
