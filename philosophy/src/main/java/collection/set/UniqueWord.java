package collection.set;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWord {

    private String path = "collection/set/SomeText.txt";

    public static void main(String[] args) {
        Set<String> set = new TreeSet(new TextFile("path"));
        System.out.println(set);
    }

    //TODO Лень писать, потом доделать
    static class TextFile extends ArrayList {

        String path;

        public TextFile(String string) {
            this.path = string;
        }
    }
}
