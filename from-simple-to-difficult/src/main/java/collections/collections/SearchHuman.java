package collections.collections;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchHuman {

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
        fillList(humanList);
        Collections.sort(humanList);
        Human required = new Human(Age.Elder, Nationality.Italian);
        System.out.println(
                getIndexSearchElement(humanList, required)
        );
    }

    /**
     * Бинарный поиск
     * @param list
     * @param required
     * @return
     */
    private static int getIndexSearchElement(List<Human> list, Human required) {
        int i = Collections.binarySearch(list, required);
        return i;
    }

    /**
     * Заполняет лис
     * @param list
     * @return
     */
    private static List<Human> fillList(List<Human> list) {
        for (int i = 0; i < 100; i++) {
            list.add(new Human(
                    Age.values()[getRandomNumber(5)], Nationality.values()[getRandomNumber(5)])
            );
        }
        System.out.println("Size : " + list.size());
        return list;
    }

    /**
     * Генерирует случайное число
     * @param max
     * @return
     */
    private static int getRandomNumber(int max) {
        SecureRandom random = new SecureRandom();
        int i = random.nextInt(max);
        return i;
    }
}
