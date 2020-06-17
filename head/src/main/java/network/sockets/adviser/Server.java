package network.sockets.adviser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port = 4343;

    public String file;

    public Server(String name) {
        this.file = name;
    }

    public static void main(String[] args) {
        Server server = new Server("answers.txt");
        server.queryProcessing();
    }

    /**
     * This method process input query from client and sending back message;
     */
    public void queryProcessing() {
        try{
            ServerSocket serverSocket = new ServerSocket(port);

            //TODO Мне это не нравится
            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.println(getAnswer());

                // Нужно закрыть соединение, чтобы сообщение было передано
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return file by name from resource;
     * @param name - file name
     * @return
     */
    private File getFile(String name) {
        ClassLoader classLoader = Server.class.getClassLoader();
        File file = new File(classLoader.getResource(name).getFile());
        return file;
    }

    /**
     * Return string from file;
     * @return
     */
    private String getAnswer() {
        String result = null;
        try(BufferedReader br = new BufferedReader(new FileReader(getFile(this.file)))) {
            result = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method return random string
     */
    private String randomString() {
        //TODO finish writing
        return null;
    }
}
