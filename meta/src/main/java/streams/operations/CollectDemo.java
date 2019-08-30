package streams.operations;

import streams.operations.entity.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {

    public void colors() {
        List<String> colors = new ArrayList<>();
        Collections.addAll(colors, "Red", "White", "Black", "Blue");

        colors = colors.stream()
                .filter(x -> x.length() > 3)
                .collect(Collectors.toList());

        for (String s : colors) {
            System.out.println(s);
        }
    }

    public void phonesMap() {
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000)
        );

        Map<Phone,String> filterPhones = phoneStream.filter(
                p -> {
                    return p.getPrice() > 40000;
                })
                .collect(Collectors.toMap(p -> p, Phone::getName));
        filterPhones.forEach((k,v)->System.out.println(k + " " + v));
    }

    public static void main(String[] args) {
        new CollectDemo().phonesMap();
    }
}
