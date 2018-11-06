package Assignment4;

public class SelfishWorld {
    String previousConsumer="";
    boolean isSelfish(String currentConsumer){
        if(previousConsumer.equals(currentConsumer)){
            return true;
        }
        else {
            previousConsumer=currentConsumer;
            return false;
        }
    }
}
