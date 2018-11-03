package Assignment3.Assignment3_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonWithEnumTest {
    SingletonWithEnum Obj1 = SingletonWithEnum.INSTANCE;
    SingletonWithEnum Obj2 = SingletonWithEnum.INSTANCE;

    @Test
    public void shouldReturnTrueIfTwoObjectsReferSameInstance() {
        assertEquals(Obj1, Obj2);
    }
}


