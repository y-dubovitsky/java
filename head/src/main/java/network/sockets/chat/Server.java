package network.sockets.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//TODO
// разобраться почему и что не работает!

public class Server {

    private final int port = 4343;

    public static void main(String[] args) {
        new Server().connection();
    }

    public void connection() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                sendMsg(socket.getOutputStream(), "Hello from the Server");
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(OutputStream out, String msg) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        try {
            writer.write(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
