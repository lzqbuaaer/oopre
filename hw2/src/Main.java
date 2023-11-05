import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int m = scanner.nextInt();
            if (1 == m) { //add adventure
                int advId = scanner.nextInt();
                String advName = scanner.next();
                Adventure newAdv = new Adventure(advId, advName);
                adventures.put(advId, newAdv);
            } else if (2 == m) { //add bottle
                int advId = scanner.nextInt();
                int botId = scanner.nextInt();
                String botName = scanner.next();
                int botCap = scanner.nextInt();
                Adventure adv = adventures.get(advId);
                adv.addBottle(botId, botName, botCap);
            } else if (3 == m) { //remove bottle
                int advId = scanner.nextInt();
                int botId = scanner.nextInt();
                Adventure adv = adventures.get(advId);
                adv.removeBottle(botId);
            } else if (4 == m) { //add equipment
                int advId = scanner.nextInt();
                int equId = scanner.nextInt();
                String equName = scanner.next();
                int equStar = scanner.nextInt();
                Adventure adv = adventures.get(advId);
                adv.addEquipment(equId, equName, equStar);
            } else if (5 == m) { //remove equipment
                int advId = scanner.nextInt();
                int equId = scanner.nextInt();
                Adventure adv = adventures.get(advId);
                adv.removeEquipment(equId);
            } else if (6 == m) { //up star
                int advId = scanner.nextInt();
                int equId = scanner.nextInt();
                Adventure adv = adventures.get(advId);
                adv.upStar(equId);
            }
        }
        scanner.close();
    }
}
