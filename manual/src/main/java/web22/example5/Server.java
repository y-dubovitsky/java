package web22.example5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private final static int serverPort = 2999;
    private final static int clientPort = 3000;

    public static void main(String[] args) throws Exception{

        byte[] buffer = "Send from server".getBytes();

        DatagramPacket datagramPacket = new DatagramPacket(buffer, 10, InetAddress.getLocalHost(), clientPort);
        DatagramSocket datagramSocket = new DatagramSocket(serverPort);
        while (true) {
            Thread.sleep(1000);
            datagramSocket.send(datagramPacket);
        }
    }
}
