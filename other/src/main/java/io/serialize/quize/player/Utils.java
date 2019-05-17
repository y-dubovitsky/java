package io.serialize.quize.player;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Class of utils
 */
public class Utils {

    public static void main(String[] args) {
        ClassLoader classLoader = Utils.class.getClassLoader();
        File file = new File(classLoader.getResource("answers.txt").getFile());
        String[] st = Utils.split(new File("C:\\Users\\user\\IdeaProjects\\java\\other\\src\\main\\java\\io\\serialize\\quize\\player\\Utils.java"), ".");
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i]);
        }
    }

    //TODO make refactoring of this method
    /**
     * This method return array of Strings from file splitted by spliterator.
     * @param file - input file
     * @param splitter - splitter
     * @return
     */
    public static String[] split(@NotNull File file, String splitter) {
        String[] result = null;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            CharBuffer charBuffer = CharBuffer.allocate((int)file.length() + 1000);
            br.read(charBuffer);
            result = charBuffer.toString().split(splitter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
