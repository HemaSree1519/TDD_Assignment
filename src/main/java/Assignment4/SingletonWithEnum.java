package Assignment4;

public enum SingletonWithEnum {
    INSTANCE;
    int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
