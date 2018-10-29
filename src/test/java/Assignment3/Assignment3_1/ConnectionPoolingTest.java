package Assignment3.Assignment3_1;

import org.junit.Test;

import java.sql.Connection;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ConnectionPoolingTest {

    private static int POOL_SIZE = 5;

    @Test
    public void validateConnectionCreation() throws SQLException {
        Connection connection = (Connection) ConnectionPooling
                .createConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                        "password");

        assertTrue(connection.isValid(1));
    }

    @Test
    public void checkConnectionPoolCreation() throws SQLException {
        ConnectionPool connectionPool = ConnectionPooling
                .create("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");

        assertTrue(connectionPool.getConnection().isValid(1));
    }

    @Test
    public void returnConnectionIfGetConnectionCountLessThanPoolSize() throws SQLException {
        ConnectionPool connectionPool = ConnectionPooling
                .create("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        for (int count = 0; count < POOL_SIZE; count++) {
            assertTrue(connectionPool.getConnection().isValid(1));
        }
    }

    @Test
    public void throwExceptionIfGetConnectionCountExceeds() throws SQLException {
        ConnectionPool connectionPool = ConnectionPooling
                .create("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");

        try {
            for (int count = 0; count < POOL_SIZE + 1; count++) {
                assertTrue(connectionPool.getConnection().isValid(1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    @Test
    public void validateReturnConnection() throws SQLException {
        ConnectionPool connectionPool = ConnectionPooling
                .create("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        Connection connection = connectionPool.getConnection();

        assertTrue(connectionPool.returnConnection(connection));

    }

    @Test
    public void GetConnectionAfterLimitReachedIfReturnedConnection() throws SQLException {
        ConnectionPool connectionPool = ConnectionPooling
                .create("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        for (int count = 0; count < POOL_SIZE - 1; count++) {
            assertTrue(connectionPool.getConnection().isValid(1));
        }
        Connection connection5 = connectionPool.getConnection();
        try {
            Connection connection6 = connectionPool.getConnection();
        } catch (ArrayIndexOutOfBoundsException e) {
            connectionPool.returnConnection(connection5);
        }
        assertTrue(connectionPool.getConnection().isValid(1));
    }
}
