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
        input.add("10");
        input.add("RegularBottle");
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
        input.add("10");
        input.add("RegularEquipment");
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
        input.add("10");
        input.add("RegularEquipment");
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
        input.add("10");
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
        input.add("10");
        input.add("RegularEquipment");
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
        input.add("10");
        input.add("RegularBottle");
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
        input.add("10");
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
        input.add("10");
        input.add("RegularBottle");
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
        input.add("10");
        operate.addFood(input, adventures);
        operate.addFoodToBag(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("beef");
        assertEquals(operate.useFood(input, adventures), 4);
    }

    @Test
    public void beginCombat() {
        ArrayList<String> in1 = new ArrayList<>();
        in1.add("14");
        in1.add("3");
        in1.add("3");
        in1.add("advName1");
        in1.add("advName2");
        in1.add("advName3");
        ArrayList<String> in2 = new ArrayList<>();
        in2.add("2022/09-advName1-botName");
        ArrayList<String> in3 = new ArrayList<>();
        in3.add("2022/09-advName2@advName1-equName");
        ArrayList<String> in4 = new ArrayList<>();
        in4.add("2022/09-advName2@#-equName");
        ArrayList<ArrayList<String>> input = new ArrayList<>();
        input.add(in1);
        input.add(in2);
        input.add(in3);
        input.add(in4);
        Adventure adv1 = new Adventure(1, "advName1");
        adv1.addBottle(12, "botName", 60, 10, "RecoverBottle", "0.5");
        adv1.addBottleToBag(12);
        Adventure adv2 = new Adventure(2, "advName2");
        adv2.addEquipment(13, "equName", 3, 10, "EpicEquipment", "0.5");
        adv2.addEquipmentToBag(13);
        Adventure adv3 = new Adventure(3, "advName3");
        HashMap<Integer, Adventure> advs = new HashMap<>();
        advs.put(1, adv1);
        advs.put(2, adv2);
        advs.put(3, adv3);
        ArrayList<CombatLog> record = new ArrayList<>();
        Operate operate = new Operate();
        ArrayList<String> in = new ArrayList<>();
        in.add("0");
        in.add("2022/09");
        operate.printTime(in, record);
        System.out.println();
        assertEquals(operate.beginCombat(input, 0, advs, record), 3);
        in.clear();
        in.add("0");
        in.add("2022/09");
        operate.printTime(in, record);
        System.out.println();
        in.clear();
        in.add("0");
        in.add("1");
        operate.printAttack(in, advs, record);
        System.out.println();
        operate.printBeAttacked(in, advs, record);
        System.out.println();
        in.clear();
        in.add("0");
        in.add("2");
        operate.printAttack(in, advs, record);
        System.out.println();
        operate.printBeAttacked(in, advs, record);
        System.out.println();
    }

    @Test
    public void printTime() {
    }

    @Test
    public void printAttack() {
    }

    @Test
    public void printBeAttacked() {
    }

    @Test
    public void employ() {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Operate operate = new Operate();
        ArrayList<String> input = new ArrayList<>();
        input.add("0");
        input.add("123");
        input.add("lzq");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("124");
        input.add("lzq1");
        operate.addAdventure(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("124");
        operate.employ(input,adventures);
    }

    @Test
    public void countCommodity() {
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
        operate.countCommodity(input,adventures);
    }

    @Test
    public void maxPrice() {
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
        operate.maxPrice(input,adventures);
    }

    @Test
    public void findClassName() {
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
        input.add("10");
        operate.addFood(input, adventures);
        input.clear();
        input.add("0");
        input.add("123");
        input.add("12");
        operate.findClassName(input,adventures);
    }

    @Test
    public void sellAllInBag() {
    }

    @Test
    public void buy() {
    }
}