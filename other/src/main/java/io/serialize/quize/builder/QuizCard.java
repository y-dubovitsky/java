package io.serialize.quize.builder;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Quiz Card class
 */
public class QuizCard {

    /**
     * Path to file with answers
     */
    private String path;

    /**
     * Constructor
     * @param path - Path to file with answers
     */
    public QuizCard(String path) {
        this.path = path;
    }

    /**
     * This method return random string(answer) from file
     * @return
     */
    public String getAnswer() {
        String result = null;
        ClassLoader loader = QuizCard.class.getClassLoader();
        URL url = loader.getResource(path);
        File file = new File(url.getFile());
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            List<String> list = br.lines().collect(Collectors.toList());

            //returns a random number in the specified range.
            result = list.get(new Random().nextInt(list.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
