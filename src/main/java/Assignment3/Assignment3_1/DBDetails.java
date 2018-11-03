package Assignment3.Assignment3_1;

interface DBDetails {
    String getDBDriverName();

    String getDBUrl();

    String getDBUser();

    String getDBUserPswd();

    int getConnectionPoolSize();
}
