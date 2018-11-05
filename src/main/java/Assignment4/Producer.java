package Assignment4;

public class Producer extends Thread {
    private ConnectionManager connectionManager;
    public Producer(ConnectionManager connectionManager){
        this.connectionManager=connectionManager;
    }
    @Override
    public void run() {
        synchronized (this){
            connectionManager.produce();
        }
        run();
    }
}
