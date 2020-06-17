package network.threads.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ServerThread {

    ArrayList<PrintWriter> clientOutputStreams;
    private final int port = 4343;

    public static void main(String[] args) {
        ServerThread serverThread = new ServerThread();
        serverThread.start();
    }

    public void start() {
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                clientOutputStreams.add(writer);

                // starting new Thread
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tellEveryone(String msg) {
        Iterator<PrintWriter> iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            PrintWriter writer = iterator.next();
            writer.println(msg);
            writer.flush();
        }
    }


    public class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket clientSocket) {
            try{
                socket = clientSocket;
                InputStreamReader r = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(r);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String msg;
            try {
                while ((msg = reader.readLine()) != null) {
                    System.out.println(msg);
                    tellEveryone(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
