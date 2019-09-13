package first.collections.set;

import java.io.InputStream;
import java.util.*;

/**
 * This class show how to use SET
 */
public class HashSetTest {

    private final InputStream is = System.in;
    private static final String stop = "stop";

    /**
     * Input some words from console;
     * @return - HashSet
     */
    public Set<?> setFromInput() {
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            String word = scanner.next();
            set.add(word);
            if (word.equals(stop)) break;
        }
        return set;
    }

    /**
     * Output set
     * @param set
     */
    public void outSet(Set<?> set) {
        Iterator<?> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        HashSetTest set = new HashSetTest();
        set.outSet(set.setFromInput());
    }
}
