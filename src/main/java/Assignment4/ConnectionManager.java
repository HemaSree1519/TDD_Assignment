package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ConnectionManager {
    private static ConnectionManager connectionManager;
    private static DBConfiguration dbConfiguration;
    private final List<Connection> connectionPool;
    private SelfishWorld selfishWorld = new SelfishWorld();
    private List<Connection> usedConnections = new ArrayList<>();

    ConnectionManager(DBConfiguration dbConfiguration) {
        this.dbConfiguration = dbConfiguration;
        this.connectionPool = new ArrayList<>(dbConfiguration.getConnectionPoolSize());
    }

    static ConnectionManager getInstance(DBConfiguration dbConfiguration) {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager(dbConfiguration);
        }
        return connectionManager;
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

            connection = DriverManager.getConnection(dbConfiguration.getDBUrl(), dbConfiguration.getDBUser(), dbConfiguration.getDBUserPswd());

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

    Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    void closeConnection(Connection connection) {
        try {
            usedConnections.remove(connection);
            connection.close();
            System.out.println(Thread.currentThread().getName() + " returned and closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    synchronized void produce() {

        while (true) {
            while (connectionPool.size() == dbConfiguration.getConnectionPoolSize()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Produced new connection");
            Connection connection = createConnection();
            connectionPool.add(connection);
            notifyAll();
        }
    }

    synchronized Connection consume() {
        while (connectionPool.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection connection = getConnection();
        System.out.println(Thread.currentThread().getName() + " Consumed");
        notifyAll();
        if(selfishWorld.isSelfish(Thread.currentThread().getName()))
        {
            try {
                System.out.println(Thread.currentThread().getName()+" is Sleeping");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
