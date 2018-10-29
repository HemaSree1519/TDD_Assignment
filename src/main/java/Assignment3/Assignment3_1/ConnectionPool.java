package Assignment3.Assignment3_1;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    Connection getConnection() throws SQLException;

    boolean returnConnection(Connection connection);
}
