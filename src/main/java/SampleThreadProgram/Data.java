package SampleThreadProgram;

public class Data {
    private String receivedPacket;
    private boolean transferNow = true;
    public synchronized void send(String packet){
        while(!transferNow){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
        transferNow =false;
        this.receivedPacket=packet;
        notifyAll();
    }

    public synchronized String receive(){
        while(transferNow)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        transferNow=true; //receiver telling sender that sender can transfer now so that receiver will wait till sender sends.
        return receivedPacket;
    }
}
