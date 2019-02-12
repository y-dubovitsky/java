package web22.page818;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhoIs {

    public Socket createConnection(InetAddress inetAddress, int port) {
        try {
            return new Socket(inetAddress, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        // Create Socket connection
        Socket socket = new Socket("whois.internic.net", 43);

        // Get IO Stream
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // Create statement
        String str = "MHProfe s s i onal . com";

        // Convert string to byte array
        byte[] bytes = str.getBytes();

        // Send statement
        outputStream.write(bytes);

        // Get result statement
        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

        // close Socket;
        socket.close();
    }
}
