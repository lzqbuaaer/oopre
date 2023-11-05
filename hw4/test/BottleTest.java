import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Bottle bottle = new Bottle(123, "test", 80);
        bottle.setZero();
        assertEquals(0, bottle.getCapacity());
    }
}