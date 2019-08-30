package streams.creation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class describes how to use Stream Api
 */
public class Program {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        Collections.addAll(colors, "Red", "Black", "White", "Blue");
        // getting stream
        colors.stream()
                .filter(t -> t.length() > 3)
                .forEach(t -> System.out.println(t.toUpperCase()));
    }
}
