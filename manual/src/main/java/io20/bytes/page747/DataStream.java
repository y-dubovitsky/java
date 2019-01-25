package io20.bytes.page747;

import java.io.*;

public class DataStream {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\page747\\out.txt");
        try {
            DataOutputStream d = new DataOutputStream(new FileOutputStream(file));
            // Записываем примитив boolean
            d.writeBoolean(true);
            d.writeBytes("Привет");
            d.writeInt(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
