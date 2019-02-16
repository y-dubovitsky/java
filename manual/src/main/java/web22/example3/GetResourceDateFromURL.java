package web22.example3;

import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class GetResourceDateFromURL {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://github.com/y-dubovitsky");

        // Получаем URLConnection
        URLConnection urlConnection = url.openConnection();

        DataInputStream dataInputStream = new DataInputStream(urlConnection.getInputStream());
        System.out.println(dataInputStream.readUTF());

        // Получаем дату последней модификации
        System.out.println(new Date(urlConnection.getLastModified()));
    }
}
