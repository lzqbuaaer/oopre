import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {

    @Test
    public void addEqument() {
        Bag bag = new Bag();
        bag.addEqument("sword");
        assertTrue(bag.findEqument("sword"));
    }

    @Test
    public void findEquipment() {
        Bag bag = new Bag();
        bag.addEqument("sword");
        assertTrue(bag.findEqument("sword"));
    }

    @Test
    public void findBottle() {
    }

    @Test
    public void bottleSize() {
        Bag bag = new Bag();
        assertEquals(0, bag.bottleSize("sword"));
    }

    @Test
    public void createBottle() {
        Bag bag = new Bag();
        bag.createBottle("water", 123);
        assertTrue(bag.findBottle("water"));
        assertEquals(1, bag.bottleSize("water"));
    }

    @Test
    public void addBottle() {
        Bag bag = new Bag();
        bag.createBottle("water", 123);
        bag.addBottle("water", 456);
        assertEquals(bag.bottleSize("water"), 2);
        bag.removeBottle("water", 123);
        assertEquals(bag.bottleSize("water"), 1);
    }

    @Test
    public void findFood() {
    }

    @Test
    public void createFood() {
        Bag bag = new Bag();
        bag.createFood("beef", 123);
        assertTrue(bag.findFood("beef"));
    }

    @Test
    public void addFood() {
        Bag bag = new Bag();
        bag.createFood("beef", 123);
        bag.addFood("beef", 456);
        assertTrue(bag.findFood("beef"));
        bag.addFood("bread", 789);
        assertTrue(bag.findFood("bread"));
    }

    @Test
    public void useBottle() {
        Bag bag = new Bag();
        assertEquals(bag.useBottle("water"), -1);
        bag.createBottle("water", 123);
        assertEquals(bag.useBottle("water"), 123);
    }

    @Test
    public void removeBottle() {
    }

    @Test
    public void useFood() {
        Bag bag = new Bag();
        assertEquals(bag.useFood("beef"), -1);
        bag.createFood("beef", 123);
        assertEquals(bag.useFood("beef"), 123);
    }
}