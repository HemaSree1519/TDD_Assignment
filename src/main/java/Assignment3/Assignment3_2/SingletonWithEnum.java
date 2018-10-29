package Assignment3.Assignment3_2;

public enum SingletonWithEnum {
    INSTANCE;
    int data;

    public void setValue(int data) {
        this.data = data;
    }

    public int getValue() {
        return data;
    }
}

