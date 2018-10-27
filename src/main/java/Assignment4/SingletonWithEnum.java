package Assignment4;

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

