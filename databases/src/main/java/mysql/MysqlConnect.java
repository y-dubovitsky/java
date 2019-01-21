package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MysqlConnect {
    /**
     * Данные БД.
     * Из консольного вывода видно, что проблема заключается с SSL и часовым поясом. Чтобы решить данную проблему,
     * необходимо указать в адресе подключения часовой пояс бд и параметры для использования ssl.
     * В частности, я указываю, что SSL не будет использоваться и что часовым поясом будет московский часовой пояс:
     * Параметры подключения указываются после вопросительного знака после названия базы данных.
     * Параметр serverTimezone указывает на название часового пояса сервера бд.
     * В данном случае "Europe/Moscow", cписок всех допустимых названий часовых поясов можно найти на странице
     * https://gist.github.com/kinjal/9105369. И параметр useSSL=false указывает, что SSL не будет применяться.
     */
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=Europe/Moscow&useSSL=NO";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Инициализирует соединение с БД.
     */
    private Connection connection;

    /**
     * Свойства БД
     */
    private Properties properties;

    /**
     * Запросы к БД
     */
    private Statement statement;

    /**
     * Список свойст
     * @return
     */
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    /**
     * Устанавливаем соединение с БД.
     * @return
     */
    public Connection connect() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Отключение соединения
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод, выполняющий запросы: insert; Может получать несколько наборов resultSet-ов.
     * @param sql - sql запрос.
     */
    public void statement(String sql) {
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Запрос не выполнен");
        }
    }
}
