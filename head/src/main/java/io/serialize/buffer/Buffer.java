package io.serialize.buffer;

import java.io.*;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * https://ru.stackoverflow.com/questions/682123/%D0%9A%D0%B0%D0%BA-%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B8%D1%82%D1%8C-%D0%BF%D1%83%D1%82%D1%8C-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D1%83-java
 *
 * Для получения директории, в которой находится класс, можно использовать такой код:
 *
 *  File currentClass = new File(URLDecoder.decode(ВашКласс.class
 *                 .getProtectionDomain()
 *                 .getCodeSource()
 *                 .getLocation()
 *                 .getPath(), "UTF-8"));
 *  String classDirectory = currentClass.getParent();
 */
public class Buffer {

    /**
     * This method write to file all data from this compiled class.
     */
    public void writeToFile(String fileOut) {
        try{
            File fIn = new File(URLDecoder.decode(Buffer.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .getPath()) +
                    regex("\\.", Buffer.class.getName(), "\\\\") + ".class");
            File fOut = new File(fileOut);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fOut));
            BufferedReader br = new BufferedReader(new FileReader(fIn));
            String str = null;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                // add new string symbol
                bw.write("\n");
            }
            // sending all data from buffer to file
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method replace pattern symbols from inputString to replace symbols.
     * @return
     */
    String regex(String pattern, String inputString, String replace) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(inputString);
        return matcher.replaceAll(replace);
    }
}
