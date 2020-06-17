package socket.chat;

import java.net.InetAddress;

/**
 * Start application
 */
public class StartChat {
    //TODO Как запустить приложение отсюда?
    public static void main(String[] args) throws Exception{
        Server server = new Server(4004);
        server.getMsg();
        Thread.sleep(5000);
        Client client = new Client(InetAddress.getLocalHost(), 4004);
        client.createSocket();
        client.sendMsg();
    }
}
