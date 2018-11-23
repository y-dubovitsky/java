package prepearedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

/**
 * Класс для работы с БД mysql.
 */
public class Main {

    /**
     * Переменные для соединения с DB.
     */
    private String url = "jdbc:mysql://localhost:3306/mydbtest";
    private String name = "admin";
    private String password = "admin";
    private Connection connection;

    /**
     * Переменные для формирования запросов к DB.
     */
    private String sql = "INSERT INTO dishes VALUE(?,?,?,?,?,?)";
    private PreparedStatement preparedStatement;

    /**
     * Главный метод, запускающий программу.
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.doPremareStatement();
    }

    /**
     * Метод, отвечающий за выполнение "подготовленыых" запросов к БД.
     */
    public void doPremareStatement() {
        try {
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement(sql);
            /*
            Непонятно зачем вводить id, если он autoIncrement
             */
            preparedStatement.setString(1, "3");
            preparedStatement.setString(2, "Hard Bread");
            preparedStatement.setString(3, "This bread is soooo hard and disgusting");
            preparedStatement.setDouble(4, 9.5);
            /*
            new Date(Calendar.getInstance().getTimeInMillis()) Посмотреть в чем разница.
             */
            preparedStatement.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setBlob(6, new FileInputStream("C:\\projects\\dbproject\\src\\main\\java\\prepearedstatement\\googlelogo_color_120x44dp.png"));
            preparedStatement.execute();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
