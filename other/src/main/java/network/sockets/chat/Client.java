package network.sockets.chat;

import java.io.*;
import java.net.Socket;

public class Client {

    private final int port = 4343;
    private final String ip = "127.0.0.1";
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;

    public static void main(String[] args) {
        new Client().getConnection();
    }

    public void getConnection() {
        try {
            socket = new Socket(ip, port);
            while (true) {
                System.out.println(getMsg(socket.getInputStream()));
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getMsg(InputStream is) {
        String result = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try{
            result = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
