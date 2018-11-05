package Assignment4;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        DBConfiguration dbConfiguration = new DBConfiguration();
        ConnectionManager connectionManager = new ConnectionManager(dbConfiguration);
        Thread producer = new Thread(new Producer(connectionManager));
        Thread consumer1 = new Thread(new Consumer(connectionManager));
        Thread consumer2 = new Thread(new Consumer(connectionManager));
        Thread consumer3 = new Thread(new Consumer(connectionManager));
        Thread consumer4 = new Thread(new Consumer(connectionManager));
        Thread consumer5 = new Thread(new Consumer(connectionManager));
        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
    }
}
