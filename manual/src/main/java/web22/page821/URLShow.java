package web22.page821;

import java.net.MalformedURLException;
import java.net.URL;

public class URLShow {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.google.com");
        System.out.println("Protocol " + url.getProtocol());
        System.out.println("Port " + url.getPort());

        System.out.println("Host " + url.getHost());
        System.out.println("Path " + url.getPath());
    }
}
