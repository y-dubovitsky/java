package stream29.page1080;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * THis class show how to use collect() method from Stream API
 */
public class CollectShow {

    static class Person {
        String name;
        String male;

        Person(String name, String male) {
            this.male = male;
            this.name = name;
        }
    }

    static class Worker {
        Person person;
        String post;

        Worker(Person person, String post) {
            this.person = person;
            this.post = post;
        }
    }

    public static void main(String[] args) {
        // create stream with 2 various worker;
        Stream<Worker> workerStream = Stream.of(
                new Worker(
                        new Person("Ivan", "elf-male"), "enginere"),
                new Worker(
                        new Person("Aletta", "female"), "stripper"
                )
        );

        // mirror first stream at new Stream
        Stream<Person> personStream = workerStream
                .map((n) -> n.person);

        // Collect all Persons from Stream in new Collection(List).
        List<Person> list = personStream.collect(Collectors.toList());

        // sout
        for (Person person : list) {
            System.out.println(person.name + " " + person.male);
        }
    }
}
