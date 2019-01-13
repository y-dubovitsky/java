package postpreg;

/**
 * Главный класс, запускающий все приложение.
 */
public class Initialization {

    /**
     * main метод;
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Postpreg postpreg = new Postpreg();
        postpreg.setConnection();
        //postpreg.doQueru("SELECT * FROM users");
        //postpreg.showAllFields();
    }
}
