import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CombatTest {

    @Test
    public void execute() {
        ArrayList<String> in1 = new ArrayList<>();
        in1.add("14");
        in1.add("3");
        in1.add("2");
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
        Adventure adv1 = new Adventure(1,"advName1");
        adv1.addBottle(12,"botName",60,10,"RegularBottle",null);
        adv1.addBottleToBag(12);
        Adventure adv2 = new Adventure(2,"advName2");
        adv2.addEquipment(13,"equName",3,10,"RegularEquipment",null);
        adv2.addEquipmentToBag(13);
        Adventure adv3 = new Adventure(3,"advName3");
        HashMap<Integer,Adventure> advs = new HashMap<>();
        advs.put(1,adv1);
        advs.put(2,adv2);
        advs.put(3,adv3);
        Combat combat = new Combat(input,0,advs);
        CombatLog record = new CombatLog(input,0);
        combat.execute(input.get(1).get(0),record);
        assertEquals(adv1.getHitPoint(),560);
        combat.execute(input.get(2).get(0),record);
        assertEquals(adv1.getHitPoint(),557);
        combat.execute(input.get(3).get(0),record);
        assertEquals(adv1.getHitPoint(),554);
        assertEquals(adv3.getHitPoint(),497);
        assertEquals(adv2.getHitPoint(),500);
        combat.execute("2022/09-advName1-botName1",record);
        combat.execute("2022/09-advName4-botName",record);
        combat.execute("2022/09-advName2@advName4-equName",record);
        combat.execute("2022/09-advName2@advName1-equName1",record);
        combat.execute("2022/09-advName4@#-equName",record);
        combat.execute("2022/09-advName2@#-equName1",record);
        assertTrue(record.printTime("2022/09"));
        System.out.println();
        assertFalse(record.printAttack("advName1"));
        System.out.println();
        assertFalse(record.printBeAttacked("advName2"));
        System.out.println();
        assertTrue(record.printAttack("advName2"));
        System.out.println();
        assertTrue(record.printBeAttacked("advName1"));
    }

    @Test
    public void conduct1() {
    }

    @Test
    public void conduct2() {
    }

    @Test
    public void conduct3() {
    }
}