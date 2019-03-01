package stream29.page1078;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class show hot to reflect list at Stream, uses map.
 */
public class MapShow {

    static class People {
        Name name;
        String address;

        People(Name name, String address) {
            this.address = address;
            this.name = name;
        }
    }

    static class Name {
        String name;

        Name(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<People> people = Arrays.asList(new People(new Name("Ivan"), "Moscow"),
                new People(new Name("Dasha"), "St-Petersburg"));

        // Reflect; n - People, result - Name.
        Stream<Name> nameStream = people.stream().map(n -> n.name);
        nameStream.forEach(System.out::println);
    }

}
