//package mysql;
//
//import com.mysql.fabric.jdbc.FabricMySQLDriver;
//
//import java.sql.*;
//
///**
// * Класс отвечающий за работу с БД.
// */
//public class ConnectionDataBase {
//    /**
//     * Список констант для соединения с БД.
//     */
//    private final String URL =
//            "jdbc:mysql://localhost:3306/mydbtest";
//    private final String USERNAME = "admin";
//    private final String PASSWORD = "admin";
//
//    /**
//     * Переменная отвечающая за запросы к БД.
//     */
//    private Statement statement;
//
//    /**
//     * Переменная отвечающая за соединение с БД.
//     */
//    private Connection connection;
//
//    /**
//     * Метод, устанавливающий соединение с БД.
//     */
//    Connection connector() {
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            statement = connection.createStatement();
//            if (!connection.isClosed()) {
//                System.out.println("Соединение с БД Установлено!");
//            }
//            if (connection.isClosed()) {
//                System.out.println("Соединение с БД Закрыто!");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getSQLState());
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    /**
//     * Метод показывает установленно ли соединение
//     * @return - возвращает true, если закрыто и false в другом случае.
//     */
//    boolean getConnection() throws SQLException{
//        return connection.isClosed();
//    }
//
//    /**
//     * Метод, выполняющий запросы: insert;
//     * Может получать несколько наборов resultSet-ов.
//     * @param sql - sql запрос.
//     */
//    public void statement(String sql) {
//        try {
//            statement.execute(sql);
//        } catch (SQLException e) {
//            System.out.println("Запрос не выполнен");
//        }
//    }
//
//    /**
//     * Метод может выполнять запросы типа: insert, update и delete.
//     * @return - возвращает количество записей в которые он внес изменения.
//     */
//    int update(String sql) {
//        int result = 0;
//        try {
//            result = statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            System.out.println("Неудалось выполнить запрос.");
//        }
//        return result;
//    }
//
//    /**
//     * Метод возвращает ResultSet
//     * @param sql - запрос к БД
//     * @return - ResultSet
//     */
//    ResultSet getResultSet(String sql) {
//        ResultSet resultSet = null;
//        try {
//            resultSet = statement.executeQuery(sql);
//        } catch (SQLException e) {
//            System.out.println("Не удалось получить ResultSet");
//        }
//        return resultSet;
//    }
//
//    /**
//     * Метод выполняет "пачку" запросов.
//     * После выполнения запросов, вся пачка запросов очищается.
//     */
//    void executeBatch(String[] sql) {
//        try {
//            for (String aSql : sql) {
//                statement.addBatch(aSql);
//            }
//            statement.executeBatch();
//            statement.clearBatch();
//        } catch (SQLException e) {
//            System.out.println("Не удалось выполнить стопу запросов");
//        }
//    }
//}
