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

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver not found");
            e.printStackTrace();
            return null;

        }

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

            System.out.println("Connection Failed !");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
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
    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < POOL_SIZE) {
                connectionPool.add(createConnection(url, user, password));
            } else {
                try {
                    throw new PoolSizeOverFlowException();
                } catch (PoolSizeOverFlowException e) {
                    System.out.println(e);
                }
            }
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean returnConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);

    }
}
