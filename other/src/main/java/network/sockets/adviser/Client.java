package network.sockets.adviser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * The client class;
 */
public class Client {

    private String ip = "127.0.0.1";
    private int port = 4343;
    private String answer;

    // TODO may be refactoring?
    private final GUI gui = new GUI();

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.gui.createInterface();

        // TODO Тоже плохо, нужно включить обработку нажатия кнопки
        while (true) {
            Thread.sleep(1000);
            client.getAnswer();
        }
    }

    /**
     * This method return a answer from server machine;
     */
    public void getAnswer() {
        try(Socket socket = new Socket(ip, port)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.gui.setStr(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
