import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        ArrayList<ArrayList<String>> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        Operate operate = new Operate();
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine();
            String[] strings = nextLine.trim().split(" +");
            input.add(new ArrayList<>(Arrays.asList(strings)));
        }
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
                default:
            }
        }
        scanner.close();
    }
}