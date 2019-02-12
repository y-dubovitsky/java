package web22.page825;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLShow {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection urlConnection = url.openConnection();

            // Делаем приведение
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

            // Функции
            System.out.println("Method of request " + httpURLConnection.getRequestMethod());
            System.out.println("Code of answer " + httpURLConnection.getResponseCode());
            System.out.println("Response message " + httpURLConnection.getResponseMessage());

            // List of Fields and Values
            Map<String, List<String>> list = httpURLConnection.getHeaderFields();
            Set<String> fields = list.keySet();

            // Выводим все ключи и их значения из заголовка
            for (String k : fields) {
                System.out.println("Ключ : " + k + System.lineSeparator() + " Значение : " +
                        list.get(k)); // list.get(k) - это список, выводимый как строка
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
