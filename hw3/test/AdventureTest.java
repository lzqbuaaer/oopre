import org.junit.Test;

import static org.junit.Assert.*;

public class AdventureTest {

    @Test
    public void getName() {
        Adventure adv = new Adventure(132, "lzq");
        assertEquals(adv.getName(), "lzq");
    }

    @Test
    public void addBottle() {
    }

    @Test
    public void removeBottle() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(23, "water", 60);
        assertEquals(adv.removeBottle(23), "water");
    }

    @Test
    public void addEquipment() {
    }

    @Test
    public void removeEquipment() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3);
        assertEquals(adv.removeEquipment(12), "sword");
    }

    @Test
    public void upStar() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3);
        assertEquals(adv.upStar(12), 4);
    }

    @Test
    public void addFood() {
    }

    @Test
    public void removeFood() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addFood(123, "beef", 3);
        assertEquals(adv.removeFood(123), "beef");
    }

    @Test
    public void addEquipmentToBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3);
        adv.addEquipmentToBag(12);
        assertEquals(adv.addEquipmentToBag(12), "sword");
    }

    @Test
    public void addBottleToBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(12, "water", 60);
        assertEquals(adv.addBottleToBag(12), "water");
        adv.addBottle(15, "water", 60);
        assertNull(adv.addBottleToBag(15));
    }

    @Test
    public void addFoodToBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addFood(123, "beef", 3);
        adv.addFood(153, "beef", 3);
        assertEquals(adv.addFoodToBag(123), "beef");
        assertEquals(adv.addFoodToBag(153), "beef");
    }

    @Test
    public void useBottle() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(12, "water", 60);
        adv.addBottleToBag(12);
        assertEquals(adv.useBottle("water"), 560);
        assertEquals(adv.useBottle("water"), 560);
        assertEquals(adv.useBottle("water"), -1);
    }

    @Test
    public void useFood() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addFood(123, "beef", 5);
        assertEquals(adv.useFood("beef"), -1);
        adv.addFoodToBag(123);
        assertEquals(adv.useFood("beef"), 6);
        adv.addBottle(12, "water", 60);
        assertEquals(adv.addBottleToBag(12), "water");
        adv.addBottle(15, "water", 60);
        assertEquals(adv.addBottleToBag(15), "water");
    }
}