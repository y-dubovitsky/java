package io20.bytes.example8;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOutStream {
    public static void main(String[] args) {
        String str = "package io20.bytes.example8;\n" +
                "\n" +
                "public class DataInOutStream {\n" +
                "    public static void main(String[] args) {";
        try(DataOutputStream d = new DataOutputStream(new FileOutputStream("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\bytes\\example8\\out.txt"))) {
            d.writeInt(1);
            d.write(str.getBytes());
            d.writeDouble(123514.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
