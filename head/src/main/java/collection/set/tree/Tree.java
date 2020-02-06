package collection.set.tree;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Tree {

    Set<Book> set = new TreeSet<>(new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.name.compareTo(o2.name);
        }
    });

    //TODO Почему не работает <? extends Book> должно же быть просто наследование от Book!!!
    Set<? super Book> set1 = new TreeSet<>();

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addBook();
    }

    public void addBook() {

        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново свое тело");
        Book b3 = new Book("В поисках немо");

        set.add(b1);
        set.add(b2);
        set.add(b3);

        set1.add(new ClassicBook("Классическая Книга!", 4124));
        set1.add(b2);
        set1.add(b3);

        System.out.println(set);
        System.out.println(set1);
    }


    class Book implements Comparable<Book>{

        String name;

        public Book(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(@NotNull Book o) {
            return this.name.compareTo(o.name);
        }
    }

    class ClassicBook extends Book {

        int number;

        public ClassicBook(String name, int value) {
            super(name);
            this.number = value;
        }
    }
}
