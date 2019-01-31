package io20.symbol.page758;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushBackReaderShow {
    static String str = "  if ( а == 4 ) а = 0 ; \\n";

    public static void main(String[] args) {
        char[] buff = new char[str.length()];
        //buff = str.toCharArray(); или так :
        str.getChars(0, str.length(), buff, 0);
        CharArrayReader c = new CharArrayReader(buff);
        int i; // КОД Символа который мы считываем
        try(PushbackReader p = new PushbackReader(c)) {
            while ((i = p.read()) != -1) {
                switch (i) {
                    case '=' :
                        if ((i = p.read()) == '=') {
                            System.out.print(" .eq "); // нашли два символа ==
                        } else {
                            System.out.print("<-");
                            p.unread(i); // Если условие не выполняется мы заталкиваем символ обратно
                        }
                    break;
                    default:
                        System.out.print((char)i);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
