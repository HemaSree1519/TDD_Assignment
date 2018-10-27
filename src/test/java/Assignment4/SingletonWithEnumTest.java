package Assignment4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonWithEnumTest {
    @Test
    public void shouldReturnOneForOne()
    {
        SingletonWithEnum Obj1 = SingletonWithEnum.INSTANCE;
        Obj1.setValue(1);
        assertEquals(1,Obj1.getValue());
    }
}
