package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    static String URL = "jdbc:mysql://localhost:3306/university";
    static String USER = "root";
    static String PASSWORD = "password";
    static Connection connection;

    static {
        try {
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
