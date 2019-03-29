package reflection;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetResource {
    public static final String pathTxt = "/source.txt";
    public static final String imgBmp = "/image.bmp";

    public static void main(String[] args) {

        // Get resource
        InputStream inputStream = GetResource.class.getResourceAsStream(pathTxt);

        // Checking.. if no reference.
        if (inputStream == null) {
            System.out.println("Cannot write resource");
        } else {
            //
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int c;
            try {
                while ((c = inputStream.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
