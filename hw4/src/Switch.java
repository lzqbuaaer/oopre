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
            switch (Integer.parseInt(input.get(i).get(0))) {
                case 1:
                    operate.addAdventure(input.get(i), adventures);
                    break;
                case 2:
                    operate.addBottle(input.get(i), adventures);
                    break;
                case 3:
                    operate.removeBottle(input.get(i), adventures);
                    break;
                case 4:
                    operate.addEquipment(input.get(i), adventures);
                    break;
                case 5:
                    operate.removeEquipment(input.get(i), adventures);
                    break;
                case 6:
                    operate.upStar(input.get(i), adventures);
                    break;
                case 7:
                    operate.addFood(input.get(i), adventures);
                    break;
                case 8:
                    operate.removeFood(input.get(i), adventures);
                    break;
                case 9:
                    operate.addEquipmentToBag(input.get(i), adventures);
                    break;
                case 10:
                    operate.addBottleToBag(input.get(i), adventures);
                    break;
                case 11:
                    operate.addFoodToBag(input.get(i), adventures);
                    break;
                case 12:
                    operate.useBottle(input.get(i), adventures);
                    break;
                case 13:
                    operate.useFood(input.get(i), adventures);
                    break;
                case 14:
                    i += operate.beginCombat(input, i, adventures, record);
                    break;
                case 15:
                    operate.printTime(input.get(i), record);
                    break;
                case 16:
                    operate.printAttack(input.get(i), adventures, record);
                    break;
                case 17:
                    operate.printBeAttacked(input.get(i), adventures, record);
                    break;
                default:
            }
        }
    }
}
