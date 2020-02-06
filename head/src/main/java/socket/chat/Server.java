package socket.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server side
 */
public class Server {
    Socket socket;
    int port;

    public Server(int port) {
        this.port = port;
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            // waiting client connection;
            this.socket = serverSocket.accept();
            if (this.socket != null) {
                System.out.println("Client connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
            //TODO add more behaviour
        }
    }

    // TODO add Exception Handling
    public void getMsg() throws IOException{
        try {
            InputStream inputStream = this.socket.getInputStream();
            //if (inputStream != null) {
                while (true) {
                    InputStreamReader reader = new InputStreamReader(inputStream);

                    // TODO Что то мне тут не нравится, нужно сделать рефакторинг
                    char[] buffer = new char[100];
                    reader.read(buffer, 0, buffer.length);
                    for (int i = 0; i < buffer.length; i++) {
                        System.out.print(buffer[i]);
                    }
                }
            //}
        } catch (IOException e) {

            // waiting clients data
            // TODO если клиент перестает посылать данные, программа завершится с исключением, нужно доработать
            while (this.socket.getInputStream() == null || this.socket.getInputStream().read() == -1) {
                System.out.println("Waiting clients data");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException i) {
                    e.printStackTrace();
                }
                if (this.socket.getInputStream() != null) {
                    this.getMsg();
                }
            }
            // TODO Возможно так нельзя делать, так как создается большой стек вызовов метода
            //this.getMsg();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(4004);
        server.getMsg();
    }
}
