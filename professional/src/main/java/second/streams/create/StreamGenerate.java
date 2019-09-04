package second.streams.create;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamGenerate {

    // TODO It is wrong!
    private final static String path = "C:\\Users\\user\\IdeaProjects\\java\\professional\\src\\main\\resources\\second\\streams\\operations\\text.txt";
    private final static String classPath = "C:\\Users\\user\\IdeaProjects\\java\\professional\\src\\main\\java\\second\\streams\\create\\StreamGenerate.java";

    /**
     * Generate infinity count of numbers
     */
    private static void generateInfNum() {
        Stream.generate(() -> {
            return new Random().nextInt();
        }).forEach(System.out::println);
    }

    /**
     * Generate numbers with some restriction(in function)
     */
    private static void generateRestrictionNum() {
        Stream.<Integer>iterate(5, (x) -> {
            return x < 100;
        }, y -> {
            return y = y + 10;
        }).forEach(System.out::println);
    }

    private static String getStringFile(String path) {
        String str = null;
        try {
            str = Files.readString(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * Get Stream from file, filter and output!
     * @param path
     */
    private static void fileStreamFilter(String path) {
        Path p = Paths.get(path);
        String s = null;
        try {
            s = new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        Stream.of(s.split(" "))
                .filter( x -> {
                    Pattern pattern = Pattern.compile("\\d");
                    Matcher matcher = pattern.matcher(x);
                    return matcher.find();
                })
                .forEach(System.out::println);
    }

    /**
     * Return text divided by regex;
     * @param str
     */
    private static void regexStream(String str) {
        // after symbol pr followed 0 or more symbols 'iv'
        Pattern pattern = Pattern.compile("pr(iv)*");
        System.out.println(
                pattern.splitAsStream(str)
                        .count()
        );
    }

    public static void main(String[] args) {
        //StreamGenerate.generateRestrictionNum();
        //StreamGenerate.generateInfNum();
        //StreamGenerate.fileStreamFilter(StreamGenerate.path);
        StreamGenerate.regexStream(StreamGenerate.getStringFile(StreamGenerate.classPath));
    }

}
