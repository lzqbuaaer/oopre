import org.junit.Test;


public class BottleTest {

    @Test
    public void getName() {
        Bottle tBottle = new Bottle(123, "test", 80);
        assert (tBottle.getName().equals("test"));
    }
}