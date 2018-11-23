package postpreg;

import java.sql.*;

/**
 * Класс, отвечающий за работу с PostGresSQL;
 * Была ошибка при выполнение connection = DriverManager.getConnection(db, name, password);
 * java.sql.SQLException: No suitable driver found for jdbc:postgresql://localhost:5432/postgres
 * Все решилось добавление зависимости в maven =)
 */
public class Postpreg {

    /**
     * Переменная отвечающая за соединение.
     */
    private Connection connection;
    /**
     * Переменные, отвечающий за подключение к БД.
     */
    private String table = "users";
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String name = "postgres";
    private String password = "postgres";
    /**
     * Переменная, отвчающая за запросы к БД.
     */
    private Statement statement;
    /**
     * Возвращаемая информация после выполнения sql-запроса.
     */
    private ResultSet resultSet;

    /**
     * Метод устанавливает соединение с БД.
     */
    public void setConnection() {
        try {
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }
    }

    /**
     * Метод выполняет запросы к БД.
     * @param sql - пользовательский SQL-запрос.
     */
    public ResultSet doQueru(String sql) {
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * Метод возвращает всю таблицу из БД.
     */
    public void showAllFields() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + table);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") +
                        resultSet.getString("name") +
                        resultSet.getString("job") +
                        resultSet.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
