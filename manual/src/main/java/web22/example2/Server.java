package web22.example2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    static {
        try
        {
            InetAddress inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.getMessage();
        }
    }

    private final int port = 3000;

    public Socket socket;

    public void startServer() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {

            // Получаем сокет и ждем запрос от сервера
            this.socket = serverSocket.accept();

            // Получаем потоки ввода-вывода
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String str = dataInputStream.readUTF();
                System.out.println(str);
                dataOutputStream.writeUTF("HELLO");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}
