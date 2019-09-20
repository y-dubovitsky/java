package first.collections.methods;

import java.util.*;
import java.util.function.Predicate;

/**
 * This simple class show how to use method .removeIf
 * and functional interface with lambda expression;
 */
public class RemoveIf {

    private List<Integer> list = new ArrayList<>(){{
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            add(random.nextInt());
        }
    }};

    public Predicate<Integer> getPredicate() {
        // lambda expression
        Predicate<Integer> predicate = (x) -> {
            return x % 2 == 0;
        };
        return predicate;
    }

    public void outputList(List<Integer> list) {
        list.stream()
                // just for testing
//                .peek(x -> {
//                    System.out.println("This is from peek " + x);
//                })
                .forEach(System.out::println);
    }

    public List<Integer> removeCondition(Predicate<Integer> pr, List<Integer> list) {
        list.removeIf(pr);
        return list;
    }

    public static void main(String[] args) {
        RemoveIf r = new RemoveIf();
        r.outputList(r.list);
        r.removeCondition(r.getPredicate(), r.list);
        r.outputList(r.list);
    }
}
