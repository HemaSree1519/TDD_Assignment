package Assignment3.Assignment3_1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConnectionPoolingTest {

    DBConfiguration dbConfiguration = new DBConfiguration();
    ConnectionPooling connectionPoolingInstance = ConnectionPooling.getInstance(dbConfiguration);

    @Test
    public void validateConnectionCreation() throws SQLException {

        Connection connection = (Connection) connectionPoolingInstance.createConnection();

        assertTrue(connection.isValid(1));
    }

    @Test
    public void checkConnectionPoolCreation() throws SQLException {
        //ConnectionPoolingInstance.createPool();
        connectionPoolingInstance.createPool();
        assertTrue(connectionPoolingInstance.getConnection().isValid(1));
    }

    @Test
    public void returnConnectionIfGetConnectionCountLessThanPoolSize() throws SQLException {
        connectionPoolingInstance.createPool();
        for (int count = 0; count < dbConfiguration.getConnectionPoolSize(); count++) {
            assertTrue(connectionPoolingInstance.getConnection().isValid(1));
        }
    }

    @Test
    public void throwExceptionIfGetConnectionCountExceeds() throws SQLException {
        connectionPoolingInstance.createPool();
        try {
            for (int count = 0; count < dbConfiguration.getConnectionPoolSize() + 1; count++) {

                assertTrue(connectionPoolingInstance.getConnection().isValid(1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    @Test
    public void validateReturnConnection() throws SQLException {
        connectionPoolingInstance.createPool();
        Connection connection1 = connectionPoolingInstance.getConnection();
        Connection connection2 = connectionPoolingInstance.getConnection();
        connectionPoolingInstance.returnConnection(connection1);
        assertEquals(1,connectionPoolingInstance.getUsedConnections());

    }
    @Test
    public void GetConnectionAfterLimitReachedIfReturnedConnection() throws SQLException {
        connectionPoolingInstance.createPool();

        for (int count = 0; count < dbConfiguration.getConnectionPoolSize() - 1; count++) {
            assertTrue(connectionPoolingInstance.getConnection().isValid(1));
        }
        Connection connection5 = connectionPoolingInstance.getConnection();
        try {
            Connection connection6 = connectionPoolingInstance.getConnection();
        } catch (ArrayIndexOutOfBoundsException e) {
            connectionPoolingInstance.returnConnection(connection5);
        }
        assertTrue(connectionPoolingInstance.getConnection().isValid(1));
    }

    @Test

    public void executeQuery() throws SQLException {
        connectionPoolingInstance.createPool();
        Connection connection = connectionPoolingInstance.getConnection();
        ResultSet rs = ConnectionPooling.executeTheQuery(connection, "select name from dbtestschema.table where id=01");
        rs.next();
        String name = rs.getString("name");
        String expectedName = "Hema" + "      ";
        assertEquals(expectedName, name);
    }
}