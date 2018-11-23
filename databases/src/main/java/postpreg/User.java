package postpreg;

/**
 * Класс пользователь.
 */
public class User {

    /**
     * Поле, хранящее в себя id пользователя.
     */
    private int id;

    /**
     * Поле, хранящее имя пользователя.
     */
    private String name;

    /**
     * Поле, хранящее профессию пользователя.
     */
    private String job;

    /**
     * Поле, хранящее email пользователя.
     */
    private String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }
}
