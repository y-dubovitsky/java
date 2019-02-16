package web22.example1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    Thread t;

    /**
     * Адрес для соединения.
     */
    private int port = 3000;

    public Server() {
        t = new Thread(this);
        t.start();
    }

    public void getSocketConnection() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {

            // Ждем подключения клиента
            System.out.println("Ждем подключения клиента");
            Socket socket = serverSocket.accept();

            // Получаем поток ввода-вывода
            InputStream is = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Создаем поток ввода-вывода данных
            DataInputStream inputStream = new DataInputStream(is);
            DataOutputStream outputStream = new DataOutputStream(out);

            while (true) {
                String str = inputStream.readUTF();
                System.out.println(str);

                // Отправляем ответ клиенту
                outputStream.writeUTF(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            new Server().getSocketConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
