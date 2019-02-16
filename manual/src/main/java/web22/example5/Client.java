package web22.example5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.zip.DataFormatException;

public class Client {

    private final static int clientPort = 3000;
    private final static int serverPort = 2999;

    public static void main(String[] args) {

        // Буффер
        byte[] buffer = new byte[100];

        while (true) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(clientPort);
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(datagramPacket);
                byte[] msg  =datagramPacket.getData();
                for (int i = 0; i < msg.length; i++) {
                    System.out.print((char)msg[i]);
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
