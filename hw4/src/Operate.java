import java.util.ArrayList;
import java.util.HashMap;

public class Operate {
    public Operate() {
    }

    public void addAdventure(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        String advName = input.get(2);
        Adventure newAdv = new Adventure(advId, advName);
        adventures.put(advId, newAdv);
    }

    public void addBottle(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int botId = Integer.parseInt(input.get(2));
        String botName = input.get(3);
        int botCap = Integer.parseInt(input.get(4));
        adv.addBottle(botId, botName, botCap);
    }

    public void removeBottle(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int botId = Integer.parseInt(input.get(2));
        adv.removeBottle(botId);
    }

    public void addEquipment(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int equId = Integer.parseInt(input.get(2));
        String equName = input.get(3);
        int equStar = Integer.parseInt(input.get(4));
        adv.addEquipment(equId, equName, equStar);
    }

    public void removeEquipment(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int equId = Integer.parseInt(input.get(2));
        adv.removeEquipment(equId);
    }

    public int upStar(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int equId = Integer.parseInt(input.get(2));
        return adv.upStar(equId);
    }

    public void addFood(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int foodId = Integer.parseInt(input.get(2));
        String foodName = input.get(3);
        int foodEnergy = Integer.parseInt(input.get(4));
        adv.addFood(foodId, foodName, foodEnergy);
    }

    public void removeFood(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int foodId = Integer.parseInt(input.get(2));
        adv.removeFood(foodId);
    }

    public void addEquipmentToBag(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int equId = Integer.parseInt(input.get(2));
        adv.addEquipmentToBag(equId);
    }

    public void addBottleToBag(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int botId = Integer.parseInt(input.get(2));
        adv.addBottleToBag(botId);
    }

    public void addFoodToBag(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        int foodId = Integer.parseInt(input.get(2));
        adv.addFoodToBag(foodId);
    }

    public int useBottle(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        String botName = input.get(2);
        return adv.useBottle(botName);
    }

    public int useFood(ArrayList<String> input, HashMap<Integer, Adventure> adventures) {
        int advId = Integer.parseInt(input.get(1));
        Adventure adv = adventures.get(advId);
        String foodName = input.get(2);
        return adv.useFood(foodName);
    }

    public int beginCombat(ArrayList<ArrayList<String>> input, int i,
                           HashMap<Integer, Adventure> adventures, ArrayList<CombatLog> record) {
        System.out.println("Enter Fight Mode");
        int num = Integer.parseInt(input.get(i).get(2));
        Combat combat = new Combat(input, i, adventures);
        CombatLog combatLog = new CombatLog(input, i);
        for (int j = 1; j <= num; j++) {
            combat.execute(input.get(i + j).get(0), combatLog);
        }
        record.add(combatLog);
        return num;
    }

    public void printTime(ArrayList<String> input, ArrayList<CombatLog> record) {
        String time = input.get(1);
        boolean flag = false;
        for (CombatLog log : record) {
            if (log.printTime(time)) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No Matched Log");
        }
    }

    public void printAttack(ArrayList<String> input, HashMap<Integer, Adventure> adventures,
                            ArrayList<CombatLog> record) {
        int id = Integer.parseInt(input.get(1));
        String name = adventures.get(id).getName();
        boolean flag = false;
        for (CombatLog log : record) {
            if (log.printAttack(name)) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No Matched Log");
        }
    }

    public void printBeAttacked(ArrayList<String> input, HashMap<Integer, Adventure> adventures,
                                ArrayList<CombatLog> record) {
        int id = Integer.parseInt(input.get(1));
        String name = adventures.get(id).getName();
        boolean flag = false;
        for (CombatLog log : record) {
            if (log.printBeAttacked(name)) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No Matched Log");
        }
    }
}
