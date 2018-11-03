package Assignment3.Assignment3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPooling {
    private static ConnectionPooling connectionPooling;
    private static DBConfiguration dbConfiguration;
    private final List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPooling(DBConfiguration dbConfiguration) {
        this.dbConfiguration = dbConfiguration;
        this.connectionPool = new ArrayList<>(dbConfiguration.getConnectionPoolSize());
    }

    static ConnectionPooling getInstance(DBConfiguration dbConfiguration) {
        if (connectionPooling == null) {
            connectionPooling = new ConnectionPooling(dbConfiguration);
        }
        return connectionPooling;
    }

    Connection createConnection() {

        try {

            Class.forName(dbConfiguration.getDBDriverName());

        } catch (ClassNotFoundException e) {

            System.out.println("Driver not found");
            e.printStackTrace();
            return null;

        }

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dbConfiguration.getDBUrl(), dbConfiguration.getDBUser(),dbConfiguration.getDBUserPswd());

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

    public static ResultSet executeTheQuery(Connection connection, String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

    void createPool() {
        for (int i = 0; i < dbConfiguration.getConnectionPoolSize(); i++) {
            connectionPool.add(createConnection());
        }
    }

    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < dbConfiguration.getConnectionPoolSize()) {
                connectionPool.add(createConnection());
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

    public boolean returnConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);

    }
    int getConnectionPoolsize(){
        return connectionPool.size();
    }
    int getUsedConnections(){
        return usedConnections.size();
    }
}
