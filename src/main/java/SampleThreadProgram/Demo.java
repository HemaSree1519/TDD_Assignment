package SampleThreadProgram;

public class Demo {
    public static void main(String args[])
    {
        Data data = new Data();
        Runnable senderRunnable = new Sender(data);
        Runnable receiverRunnable = new Receiver(data);
        Thread sender = new Thread(senderRunnable);
        Thread receiver = new Thread(receiverRunnable);
        sender.start();
        receiver.start();
    }
}
