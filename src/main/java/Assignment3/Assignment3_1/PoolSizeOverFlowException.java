package Assignment3.Assignment3_1;

public class PoolSizeOverFlowException extends Exception {
    public String toString() {
        return ("ConnectionPool-LimitReached !");
    }
}
