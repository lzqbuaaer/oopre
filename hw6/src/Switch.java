import java.util.ArrayList;
import java.util.HashMap;

public class Switch {
    private Operate operate;

    public Switch() {
        operate = new Operate();
    }

    public void swOpera(ArrayList<ArrayList<String>> input, int n,
                        HashMap<Integer, Adventure> adventures, ArrayList<CombatLog> record) {
        for (int i = 0; i < n; i++) {
            int sw = Integer.parseInt(input.get(i).get(0));
            if (1 == sw) {
                operate.addAdventure(input.get(i), adventures);
            } else if (2 == sw) {
                operate.addBottle(input.get(i), adventures);
            } else if (3 == sw) {
                operate.removeBottle(input.get(i), adventures);
            } else if (4 == sw) {
                operate.addEquipment(input.get(i), adventures);
            } else if (5 == sw) {
                operate.removeEquipment(input.get(i), adventures);
            } else if (6 == sw) {
                operate.upStar(input.get(i), adventures);
            } else if (7 == sw) {
                operate.addFood(input.get(i), adventures);
            } else if (8 == sw) {
                operate.removeFood(input.get(i), adventures);
            } else if (9 == sw) {
                operate.addEquipmentToBag(input.get(i), adventures);
            } else if (10 == sw) {
                operate.addBottleToBag(input.get(i), adventures);
            } else if (11 == sw) {
                operate.addFoodToBag(input.get(i), adventures);
            } else if (12 == sw) {
                operate.useBottle(input.get(i), adventures);
            } else if (13 == sw) {
                operate.useFood(input.get(i), adventures);
            } else if (14 == sw) {
                i += operate.beginCombat(input, i, adventures, record);
            } else if (15 == sw) {
                operate.printTime(input.get(i), record);
            } else if (16 == sw) {
                operate.printAttack(input.get(i), adventures, record);
            } else if (17 == sw) {
                operate.printBeAttacked(input.get(i), adventures, record);
            } else if (18 == sw) {
                operate.employ(input.get(i), adventures);
            } else if (19 == sw) {
                operate.countCommodity(input.get(i), adventures);
            } else if (20 == sw) {
                operate.maxPrice(input.get(i), adventures);
            } else if (21 == sw) {
                operate.findClassName(input.get(i), adventures);
            }
        }
    }
}
