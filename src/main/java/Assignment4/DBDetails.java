package Assignment4;

interface DBDetails {
    String getDBDriverName();

    String getDBUrl();

    String getDBUser();

    String getDBUserPswd();

    int getConnectionPoolSize();
}
