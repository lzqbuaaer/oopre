import org.junit.Test;

import static org.junit.Assert.*;

public class AdventureTest {

    @Test
    public void getId() {
        Adventure adv = new Adventure(132, "lzq");
        assertEquals(adv.getId(), 132);
    }

    @Test
    public void getName() {
        Adventure adv = new Adventure(132, "lzq");
        assertEquals(adv.getName(), "lzq");
    }

    @Test
    public void getBottle() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(23, "water", 60, 10, "RegularBottle", null);
        assertEquals(adv.getBottle(23), "water");
        assertNull(adv.getBottle(123));
        adv.addBottle(24, "water", 60, 10, "ReinforcedBottle", "0.5");
        assertEquals(adv.getBottle(24), "water");
        adv.addBottle(25, "water", 60, 10, "RecoverBottle", "0.5");
        assertEquals(adv.getBottle(25), "water");
    }

    @Test
    public void getEquipment() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3, 10, "RegularEquipment", null);
        assertEquals(adv.getEquipment(12), "sword");
        assertNull(adv.getEquipment(13));
        adv.addEquipment(13, "sword", 3, 10, "CritEquipment", "100");
        assertEquals(adv.getEquipment(13), "sword");
        adv.addEquipment(14, "sword", 3, 10, "EpicEquipment", "0.5");
        assertEquals(adv.getEquipment(14), "sword");
    }

    @Test
    public void getFood() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addFood(123, "beef", 3, 10);
        assertEquals(adv.getFood(123), "beef");
        assertNull(adv.getFood(12));
    }

    @Test
    public void getBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(23, "water", 60, 10, "RegularBottle", null);
        adv.addBottleToBag(23);
        Bag bag = adv.getBag();
        assertEquals(bag.findBottle("water"), true);
    }

    @Test
    public void getLevel() {
        Adventure adv = new Adventure(132, "lzq");
        assertEquals(adv.getLevel(), 1);
    }

    @Test
    public void getHitPoint() {
    }

    @Test
    public void addBottle() {
    }

    @Test
    public void removeBottle() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(23, "water", 60, 10, "RegularBottle", null);
        assertEquals(adv.removeBottle(23), "water");
    }

    @Test
    public void addEquipment() {
    }

    @Test
    public void removeEquipment() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3, 10, "RegularEquipment", null);
        assertEquals(adv.removeEquipment(12), "sword");
    }

    @Test
    public void upStar() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3, 10, "RegularEquipment", null);
        assertEquals(adv.upStar(12), 4);
    }

    @Test
    public void addFood() {
    }

    @Test
    public void removeFood() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addFood(123, "beef", 3, 10);
        assertEquals(adv.removeFood(123), "beef");
    }

    @Test
    public void addEquipmentToBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3, 10, "RegularEquipment", null);
        adv.addEquipmentToBag(12);
        assertEquals(adv.addEquipmentToBag(12), "sword");
    }

    @Test
    public void addBottleToBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(12, "water", 60, 10, "RegularBottle", null);
        assertEquals(adv.addBottleToBag(12), "water");
        adv.addBottle(15, "water", 60, 10, "RegularBottle", null);
        assertNull(adv.addBottleToBag(15));
    }

    @Test
    public void addFoodToBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addFood(123, "beef", 3, 10);
        adv.addFood(153, "beef", 3, 10);
        assertEquals(adv.addFoodToBag(123), "beef");
        assertEquals(adv.addFoodToBag(153), "beef");
    }

    @Test
    public void useBottle() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(12, "water", 60, 10, "RecoverBottle", "0.5");
        adv.addBottleToBag(12);
        assertEquals(adv.useBottle("water"), 750);
        assertEquals(adv.useBottle("water"), 750);
        assertEquals(adv.useBottle("water"), -1);
        adv.addBottle(13, "water1", 60, 10, "ReinforcedBottle", "0.5");
        adv.addBottleToBag(13);
        assertEquals(adv.useBottle("water1"), 840);
        adv.addBottleToBag(13);
    }

    @Test
    public void useFood() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addFood(123, "beef", 5, 10);
        assertEquals(adv.useFood("beef"), -1);
        adv.addFoodToBag(123);
        assertEquals(adv.useFood("beef"), 6);
    }

    @Test
    public void findBottleInBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addBottle(12, "water", 60, 10, "RecoverBottle", "0.5");
        adv.addBottleToBag(12);
        assertTrue(adv.findBottleInBag("water"));
    }

    @Test
    public void findEquInBag() {
        Adventure adv = new Adventure(132, "lzq");
        adv.addEquipment(12, "sword", 3, 10, "RegularEquipment", null);
        adv.addEquipmentToBag(12);
        assertTrue(adv.findEquInBag("sword"));
    }

    @Test
    public void getEquInBag() {
    }

    @Test
    public void beAttacked() {
        Adventure adv = new Adventure(132, "lzq");
        Adventure adv1 = new Adventure(123,"buaa");
        adv.addEquipment(13, "sword", 3, 10, "EpicEquipment", "0.5");
        adv.addEquipmentToBag(13);
        assertEquals(adv1.beAttacked(adv,"sword"),250);
        adv.addEquipment(12, "sword", 3, 10, "RegularEquipment", null);
        adv.addEquipmentToBag(12);
        assertEquals(adv1.beAttacked(adv,"sword"),247);
        adv.addEquipment(14, "sword", 3, 10, "CritEquipment", "10");
        adv.addEquipmentToBag(14);
        assertEquals(adv1.beAttacked(adv,"sword"),234);
    }

    @Test
    public void employAdv() {
        Adventure adv = new Adventure(132, "lzq");
        Adventure adv1 = new Adventure(123,"buaa");
        adv.employAdv(adv1);
    }

    @Test
    public void countCommodity() {
        Adventure adv = new Adventure(132, "lzq");
        assertEquals(adv.countCommodity(),0);
    }

    @Test
    public void sumPrice() {
        Adventure adv = new Adventure(132, "lzq");
        Adventure adv1 = new Adventure(123,"buaa");
        adv.employAdv(adv1);
        adv.addEquipment(13, "sword", 3, 10, "EpicEquipment", "0.5");
        adv1.addEquipment(13, "sword", 3, 10, "EpicEquipment", "0.5");
        adv.addBottle(12, "water", 60, 10, "RecoverBottle", "0.5");
        adv.addFood(123, "beef", 5, 10);
        assertEquals(adv.sumPrice(),40);
    }

    @Test
    public void maxPrice() {
        Adventure adv = new Adventure(132, "lzq");
        Adventure adv1 = new Adventure(123,"buaa");
        adv.employAdv(adv1);
        adv.addEquipment(13, "sword", 3, 10, "EpicEquipment", "0.5");
        adv1.addEquipment(13, "sword", 3, 20, "EpicEquipment", "0.5");
        adv.addBottle(12, "water", 60, 10, "RecoverBottle", "0.5");
        adv.addFood(123, "beef", 5, 10);
        assertEquals(adv.maxPrice(),20);
    }

    @Test
    public void findClassName() {
        Adventure adv = new Adventure(132, "lzq");
        Adventure adv1 = new Adventure(123,"buaa");
        adv.employAdv(adv1);
        adv.addEquipment(13, "sword", 3, 10, "EpicEquipment", "0.5");
        adv1.addEquipment(13, "sword", 3, 20, "EpicEquipment", "0.5");
        adv.addBottle(12, "water", 60, 10, "RecoverBottle", "0.5");
        adv.addFood(1234, "beef", 5, 10);
        assertEquals(adv.findClassName(123),"Adventurer");
    }
}