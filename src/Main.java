public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Thread t1 = new Thread(server);
        t1.start();
    }
}
