package web22.example2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Пытаемся преобразовать InetAdress к URL
 */
public class URLConvert {

    URL url;
    URLConnection urlConnection;

    public URLConvert(String hostName) throws Exception{

        url = new URL(hostName);
        urlConnection = url.openConnection();
    }

    public void getHeaders() {
        System.out.println(url.getProtocol());
        System.out.println(url.getPort());
        Map<String, List<String>> map = urlConnection.getHeaderFields();
        for (String str : map.keySet()) {
            System.out.print("KEY : " + str + " VALUES : ");
            for (int i = 0; i < map.get(str).size(); i++) {
                System.out.println(map.get(str));
            }
        }
    }

    public void getContent() {

    }

    public static void main(String[] args) throws Exception{
        URLConvert urlConvert = new URLConvert("https://ru.wikipedia.org/wiki/:80");
        urlConvert.getHeaders();
    }

    /**
     * не получилось!
     */
    public static void startConvert() throws Exception{
        Server server = new Server();
        URL url = new URL("file",InetAddress.getLocalHost().getHostAddress(), "3000");
        URLConnection urlConnection = url.openConnection();
        DataInputStream dataInputStream = new DataInputStream(urlConnection.getInputStream());
        dataInputStream.readUTF();
    }

}
