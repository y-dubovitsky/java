package web22.example4;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Работает!
 */
public class SendRequest {
    public static void main(String[] args) throws Exception{
        URLConnection urlConnection = new URL("https://www.google.ru/").openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
        dataOutputStream.writeUTF("Hello");

        System.out.println(httpURLConnection.getResponseMessage());

        Map<String, List<String>> map = httpURLConnection.getHeaderFields();
        Set<String> hashSet = map.keySet();
        for (String key : hashSet) {
            System.out.println("Ключ: " + key);
            for (int i = 0; i < map.get(key).size(); i++) {
                for(String list : map.get(key)) {
                    System.out.println("Значение = " + list);
                }
            }
        }
    }
}
