import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void getName() {
        Bottle tBottle = new Bottle(123, "test", 80);
        assertEquals(tBottle.getName(), "test");
    }

    @Test
    public void getCapacity() {
        Bottle tBottle = new Bottle(123, "test", 80);
        assertEquals(80, tBottle.getCapacity());
    }

    @Test
    public void setZero() {
        Bottle tBottle = new Bottle(123, "test", 80);
        tBottle.setZero();
        assertEquals(0, tBottle.getCapacity());
    }
}