import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void getName() {
        Bottle tBottle = new Bottle(123, "test", 80,10,"RegularBottle");
        assertEquals(tBottle.getName(), "test");
    }

    @Test
    public void getCapacity() {
        Bottle tBottle = new Bottle(123, "test", 80,10,"RegularBottle");
        assertEquals(80, tBottle.getCapacity());
    }

    @Test
    public void setZero() {
        Bottle bottle = new Bottle(123, "test", 80,10,"RegularBottle");
        bottle.setZero();
        assertEquals(0, bottle.getCapacity());
    }

    @Test
    public void use() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void equal() {
    }

    @Test
    public void getSize() {
    }
}