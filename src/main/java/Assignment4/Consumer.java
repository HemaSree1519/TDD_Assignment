package Assignment4;

import java.sql.Connection;

import static java.lang.Thread.sleep;

public class Consumer extends Thread {
    private ConnectionManager connectionManager;
    public Consumer(ConnectionManager connectionManager){
        this.connectionManager=connectionManager;
    }
    @Override
    public void run() {
        synchronized (this) {
            Connection connection =connectionManager.consume();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connectionManager.closeConnection(connection);
        }
        run();
    }
}
