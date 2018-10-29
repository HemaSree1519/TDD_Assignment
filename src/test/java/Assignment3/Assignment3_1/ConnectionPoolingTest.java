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
}
