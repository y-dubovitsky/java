package UserUtils;

/**
 * Класс пользователей.
 */
public class UserUtils {
    int id;
    String name;

    /**
     * Конструктор
     * @param id
     * @param name
     */
    UserUtils(int id, String name) {
        this.id = id;
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    int getId() {
        return this.id;
    }
}
