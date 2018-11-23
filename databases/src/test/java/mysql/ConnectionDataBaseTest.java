package mysql;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBaseTest {

    private final String URL =
            "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    private ConnectionDataBase connectionDataBase;

    @Before
    public void setUp() throws Exception {
        connectionDataBase = new ConnectionDataBase();
    }

    @Test
    public void whenConnectionIsSet() throws SQLException {
            Connection expected = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connectionDataBase.connector();
            assertThat(expected.isClosed(), is(connectionDataBase.getConnection()));
    }

}