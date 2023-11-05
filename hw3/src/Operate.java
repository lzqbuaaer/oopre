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
}
