package SampleThreadProgram;

import SampleThreadProgram.Data;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data=data;
    }

    @Override
    public void run() {
        String packets[] =  {"One","Two","Three","Four","Five","Quit"};
        for(String message : packets)
        {
            data.send(message);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
