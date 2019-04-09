package socket.chat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * The client class
 */
// FIXME Добавить больше модульности, сформировать нормальный API
    //TODO
    // Добавить многопоточность
    // https://javarush.ru/groups/posts/654-klassih-socket-i-serversocket-ili-allo-server-tih-menja-slihshishjh
    // http://www.quizful.net/post/java-socket-programming
    // http://www.javaportal.ru/java/articles/java_http_web/article02.html

public class Client {

    InetAddress inetAddress;
    int port;
    private Socket socket;
    private InputStream is;
    private OutputStream out;

    public Client(InetAddress inetAddress, int port) {
        this.inetAddress = inetAddress;
        this.port = port;
    }

    /**
     * This method create connection or waiting server answer
     */
    public void createSocket() {
        try{
            Socket socket = new Socket(this.inetAddress, this.port);
                    System.out.println("Connecting...");
            if (socket != null) {
                this.socket = socket;
                return;
            }
        } catch (IOException e) {
            System.out.println("Server not available... reconnect");

            // if server not available waiting connection
            while (socket == null) {
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }

                // one more try to connect
                // TODO Возможно так нельзя делать, так как создается большой стек вызовов метода
                createSocket();
            }
        }
    }

    /**
     * Sending msg on server
     */
    public void sendMsg() {
        if (this.socket != null) {
            try(OutputStream out = this.socket.getOutputStream()) {

                //TODO Fix it, it is bad realisation
                for (int i = 0; i < 100; i++) {
                    String str = "Msg # " + i;
                    System.out.println("We sending " + str);
                    out.write(str.getBytes());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                // TODO add behavior
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //TODO Это неправильно! исправить
        Client client = new Client(InetAddress.getLocalHost(), 4004);
        client.createSocket();
        client.sendMsg();
        // One more client start
        Client client1 = new Client(InetAddress.getLocalHost(), 4004);
        client1.createSocket();
        client1.sendMsg();
    }
}
