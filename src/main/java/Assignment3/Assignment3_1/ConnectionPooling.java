package Assignment3.Assignment3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPooling implements ConnectionPool {

    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static int POOL_SIZE = 5;

    public ConnectionPooling(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }

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

    public static ConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionPooling(url, user, password, pool);
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean removeConnection(Connection connection) {
        return false;
    }
}
