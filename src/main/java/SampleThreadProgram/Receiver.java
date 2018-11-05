package SampleThreadProgram;

import SampleThreadProgram.Data;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data data;

    public Receiver(Data data) {
        this.data=data;
    }

    @Override
    public void run() {
       for (String message = data.receive();!"Quit".equals(message);message=data.receive()) {
           System.out.println(message);
           try {
               Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
