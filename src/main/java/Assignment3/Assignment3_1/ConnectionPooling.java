package Assignment3.Assignment3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPooling implements ConnectionPool {

    private String url;
    private String user;
    private String password;

    public static Connection createConnection(String url, String user, String password) throws SQLException {

        System.out.println("JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver not found");
            e.printStackTrace();
            return null;

        }

        System.out.println("PostgreSQL JDBC Driver Found");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

            System.out.println("Connection Failed !");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("Connection Established !");
            return connection;
        } else {
            System.out.println("Failed to make connection !");
            return null;
        }
    }



  /*  public static ConnectionPool create(String url, String user, String password) throws SQLException {
        throws SQLException {

        }
            return DriverManager.getConnection(url, user, password);
    }*/

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public boolean removeConnection(Connection connection) {
        return false;
    }
}
