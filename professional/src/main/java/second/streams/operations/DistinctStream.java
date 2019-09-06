package second.streams.operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class DistinctStream {

    private static final String[] str = new String[]{"Hello", "Hello", "my", "name", "is Suchermann"};
    private static int count = 0;

    private static void distinctStream() {
        Stream<String> stream = Arrays.stream(str);
        stream.distinct()
                .forEach(x-> {
                    count++;
                    System.out.println(count + x);
                });
    }

    private static void sortStream() {
        Stream.of(str)
                .distinct()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() > o2.length()) return 1;
                        if (o1.length() < o2.length()) return -1;
                        else return 0;
                    }
                })
                .forEach(System.out::println);
    }

    private static void peekStream() {
        Stream.of(str)
                .peek(System.out::println)
                .map(x -> {
                    return x.hashCode();
                })
                .peek(System.out::println)
                .flatMap(x -> {
                    return Stream.of(x).sorted();
                })
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        //DistinctStream.distinctStream();
        //DistinctStream.sortStream();
        DistinctStream.peekStream();
    }
}
