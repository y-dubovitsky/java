package web22.example1;

import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws Exception{
        new Server();
        new Client(InetAddress.getLocalHost());
    }
}
