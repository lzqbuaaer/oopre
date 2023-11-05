import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class OperateTest {

    @Test
    public void addAdventure() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        assertEquals(adventures.get(123).getName(), "lzq");
    }

    @Test
    public void addBottle() {
    }

    @Test
    public void removeBottle() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("water");
        input.add("60");
        operate.addBottle(input, adventures);
        assertEquals(adventures.get(123).getBottle(12), "water");
        operate.removeBottle(input, adventures);
        assertNull(adventures.get(123).getBottle(12));
    }

    @Test
    public void addEquipment() {
    }

    @Test
    public void removeEquipment() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("sword");
        input.add("3");
        operate.addEquipment(input, adventures);
        assertEquals(adventures.get(123).getEquipment(12), "sword");
        operate.removeEquipment(input, adventures);
        assertNull(adventures.get(123).getEquipment(12));
    }

    @Test
    public void upStar() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("sword");
        input.add("3");
        operate.addEquipment(input, adventures);
        assertEquals(operate.upStar(input, adventures), 4);
    }

    @Test
    public void addFood() {
    }

    @Test
    public void removeFood() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("beef");
        input.add("3");
        operate.addFood(input, adventures);
        assertEquals(adventures.get(123).getFood(12), "beef");
        operate.removeFood(input, adventures);
        assertNull(adventures.get(123).getFood(12));
    }

    @Test
    public void addEquipmentToBag() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("sword");
        input.add("3");
        operate.addEquipment(input, adventures);
        operate.addEquipmentToBag(input, adventures);
        assertTrue(adventures.get(123).getBag().findEqument("sword"));
    }

    @Test
    public void addBottleToBag() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("water");
        input.add("60");
        operate.addBottle(input, adventures);
        operate.addBottleToBag(input, adventures);
        assertTrue(adventures.get(123).getBag().findBottle("water"));
    }

    @Test
    public void addFoodToBag() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("beef");
        input.add("3");
        operate.addFood(input, adventures);
        operate.addFoodToBag(input, adventures);
        assertTrue(adventures.get(123).getBag().findFood("beef"));
    }

    @Test
    public void useBottle() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("water");
        input.add("60");
        operate.addBottle(input, adventures);
        operate.addBottleToBag(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("water");
        assertEquals(operate.useBottle(input, adventures), 560);
    }

    @Test
    public void useFood() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        input.add("beef");
        input.add("3");
        operate.addFood(input, adventures);
        operate.addFoodToBag(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("beef");
        assertEquals(operate.useFood(input, adventures), 4);
    }
}