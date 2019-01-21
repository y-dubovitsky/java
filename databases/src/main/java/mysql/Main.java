package mysql;

/**
 * Главный класс, отвечающий за работу проекта.
 */
public class Main {

    /**
     * Главный метод.
     * @param args - параметры котороые передаются в конслои;
     *             можно использвать как sql запросы.
     */
    public static void main(String[] args) {
//        ConnectionDataBase connectionDataBase = new ConnectionDataBase();
//        connectionDataBase.connector();
//        connectionDataBase.update("insert into users(user, age, email) values(\"Jes4sie Jam\", 45, \"Jes23s@gmail.com\"); ");
        MysqlConnect mysqlConnect = new MysqlConnect();
        mysqlConnect.connect();
        mysqlConnect.statement("insert into users(id, user, age, email) values(null, \"Jes4sie Jam\", 45, \"Jes23s@gmail.com\"); ");
    }
}
