package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfiguration implements DBDetails {
    private static String DBDriverName;
    private static String DBUrl;
    private static String DBUser;
    private static String DBUserPswd;
    private static int ConnectionPoolSize;

    static {
        Properties properties = new Properties();
        try {
            InputStream stream = new FileInputStream("src/main/resources/configuration");
            properties.load(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DBDriverName = properties.getProperty("DB_DRIVER_NAME");
        DBUser = properties.getProperty("DB_USER");
        DBUrl = properties.getProperty("DB_URL");
        DBUserPswd = properties.getProperty("DB_USER_PSWD");
        ConnectionPoolSize = Integer.parseInt(properties.getProperty("CONNECTION_POOL_SIZE"));
    }

    @Override
    public String getDBDriverName() {
        return DBDriverName;
    }

    @Override
    public String getDBUrl() {
        return DBUrl;
    }

    @Override
    public String getDBUser() {
        return DBUser;
    }

    @Override
    public String getDBUserPswd() {
        return DBUserPswd;
    }

    @Override
    public int getConnectionPoolSize() {
        return ConnectionPoolSize;
    }
}
