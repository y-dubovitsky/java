package second.streams.reduction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Some class
 */
class Clazz<E extends String, V extends Integer> {

    public E name;
    public V age;

    public Clazz(E s, V a) {
        this.name = s;
        this.age = a;
    }

    @Override
    public String toString() {
        return "From override method" + name + " " + age;
    }
}


public class FindStream<T extends Clazz, S, I> {

    private Map<S, T> map = new HashMap<>();

    public Optional add(T t, S s) {
        Optional<Map<S,T>> optional = Stream.of(map)
                .map(x -> {
                    x.put(s, t);
                    return x;
                })
                .findAny();
        return optional;
    }

    public static void main(String[] args) {
        Clazz<String, Integer> clazz = new Clazz<>("First", 123);
        FindStream<Clazz, String, Integer> findStream = new FindStream<>();
        Optional<Map<String, Integer>> optional = findStream.add(clazz, "First add");
        System.out.println(optional);
    }
}
