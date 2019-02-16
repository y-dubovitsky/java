package web22.example1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable{

    Thread t;

    InetAddress ia;
    int port = 3000;

    public Client(InetAddress i) {
        this.ia = i;
        t = new Thread(this);
        t.start();
    }

    public void getConnectionToServer() throws Exception{
        try(Socket socket = new Socket(this.ia, port)) {

            // Создаем потоки ввода вывода данных
            DataInputStream dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            socket.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(
                    socket.getOutputStream()
            );

            Thread.sleep(10000);
            for (int i = 0; i < 20; i++) {
                // Посылаем запрос на сервер
                String query = "Hello my friend from server";
                dataOutputStream.writeUTF(query);

                // Получаем ответ от сервера
                System.out.println("Ответ от сервера: " + dataInputStream.readUTF());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            this.getConnectionToServer();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
