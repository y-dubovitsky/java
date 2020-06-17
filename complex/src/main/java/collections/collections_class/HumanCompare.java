package collections.collections_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HumanCompare {

    private static List<Human> humanList = new ArrayList<>(Arrays.asList( //! Сперва создаем лист ФИКС. ДЛИНЫ, затем ДИНАМИЧЕСКИЦ
            new Human(Age.Elder, Nationality.German),
            new Human(Age.Teen, Nationality.American),
            new Human(Age.Teen, Nationality.American),
            new Human(Age.Middle, Nationality.German),
            new Human(Age.Old, Nationality.German),
            new Human(Age.Young, Nationality.Japanese),
            new Human(Age.Elder, Nationality.Russian),
            new Human(Age.Elder, Nationality.Italian)
        )
    );

    public static void main(String[] args) {
        showSorting(humanList);
    }

    private static void showSorting(List<Human> humanList) {
        System.out.println(humanList); // before
        Collections.sort(humanList); // sorting
        System.out.println(humanList); // show after sorting
        Collections.shuffle(humanList); // shuffle
        System.out.println(humanList); // show after shuffle
        humanList.sort(new HumanComparator()); //sorting by comparator
        System.out.println(humanList); // show after sorting with comparator
    }
}
