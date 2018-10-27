package Assignment4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SingletonWithEnumTest {
    SingletonWithEnum Obj1 = SingletonWithEnum.INSTANCE;
    ;
    SingletonWithEnum Obj2 = SingletonWithEnum.INSTANCE;
    ;

    @Test
    public void shouldReturnOneForOne() {

        Obj1.setValue(1);
        assertEquals(1, Obj1.getValue());
    }

    @Test
    public void shouldReturnSameValueForDifferentOjects() {
        Obj2.setValue(2);
        assertEquals(2, Obj1.getValue());
    }

    @Test
    public void shouldReturnTrueIfTwoObjectsReferSameInstance() {
        assertTrue(Obj1.equals(Obj2));
    }
}


