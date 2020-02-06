package network.threads.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSimple {

    private int port = 4343;
    BufferedReader reader;

    public static void main(String[] args) {
        ServerSimple server = new ServerSimple();
        server.startUp();
    }

    private void startUp() {
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println("Hello");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
