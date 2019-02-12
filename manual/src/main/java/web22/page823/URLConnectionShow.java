package web22.page823;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLConnectionShow {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        URLConnection urlConnection = url.openConnection();

        // get input stream
        InputStream inputStream = urlConnection.getInputStream();

        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

        // Map
        Map<String, List<String>> map = urlConnection.getHeaderFields();
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
