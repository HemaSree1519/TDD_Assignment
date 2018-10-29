package Assignment3.Assignment3_1;

import org.junit.Test;

import java.sql.Connection;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ConnectionPoolingTest {

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
        for (int count = 0; count < 5; count++) {
            assertTrue(connectionPool.getConnection().isValid(1));
        }
    }
}
