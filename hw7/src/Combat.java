import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Combat {
    private int people;
    private HashMap<String, Adventure> advInCombat;
    private ArrayList<String> advName;
    private ArrayList<Integer> startHp;

    public Combat(ArrayList<ArrayList<String>> input, int i,
                  HashMap<Integer, Adventure> adventures) {
        this.people = Integer.parseInt(input.get(i).get(1));
        this.advInCombat = new HashMap<>();
        this.advName = new ArrayList<>();
        this.startHp = new ArrayList<>();
        for (int j = 0; j < people; j++) {
            String name = input.get(i).get(j + 3);
            advName.add(name);
            for (int id : adventures.keySet()) {
                if (adventures.get(id).getName().equals(name)) {
                    advInCombat.put(name, adventures.get(id));
                    startHp.add(adventures.get(id).getHitPoint());
                    break;
                }
            }
        }
    }

    public void execute(String order, CombatLog log) {
        String p1 = "([0-9/]+)-([^@#-]+)-([^@#-]+)";
        String p2 = "([0-9/]+)-([^@#-]+)@([^@#-]+)-([^@#-]+)";
        String p3 = "([0-9/]+)-([^@#-]+)@#-([^@#-]+)";
        Pattern pattern1 = Pattern.compile(p1);
        Pattern pattern2 = Pattern.compile(p2);
        Pattern pattern3 = Pattern.compile(p3);
        Matcher matcher1 = pattern1.matcher(order);
        Matcher matcher2 = pattern2.matcher(order);
        Matcher matcher3 = pattern3.matcher(order);
        if (matcher3.find()) {
            conduct3(matcher3, log);
        } else if (matcher2.find()) {
            conduct2(matcher2, log);
        } else if (matcher1.find()) {
            conduct1(matcher1, log);
        }
    }

    public void conduct1(Matcher matcher, CombatLog log) {
        Adventure adv = advInCombat.get(matcher.group(2));
        if (adv == null) {
            System.out.println("Fight log error");
            return;
        }
        String botName = matcher.group(3);
        if (!adv.findBottleInBag(botName)) {
            System.out.println("Fight log error");
            return;
        }
        adv.useBottle(botName);
        String str = matcher.group(1) + " " + matcher.group(2) + " used " + botName;
        log.addLog(str);
    }

    public void conduct2(Matcher matcher, CombatLog log) {
        Adventure adv1 = advInCombat.get(matcher.group(2));
        Adventure adv2 = advInCombat.get(matcher.group(3));
        if (adv1 == null | adv2 == null) {
            System.out.println("Fight log error");
            return;
        }
        String equName = matcher.group(4);
        if (!adv1.findEquInBag(equName)) {
            System.out.println("Fight log error");
            return;
        }
        System.out.println(adv2.getId() + " " + adv2.beAttacked(adv1, equName));
        String str = matcher.group(1) + " " +
                matcher.group(2) + " attacked " + matcher.group(3) + " with " + equName;
        log.addLog(str);
    }

    public void conduct3(Matcher matcher, CombatLog log) {
        Adventure adv = advInCombat.get(matcher.group(2));
        if (adv == null) {
            System.out.println("Fight log error");
            return;
        }
        String equName = matcher.group(3);
        if (!adv.findEquInBag(equName)) {
            System.out.println("Fight log error");
            return;
        }
        for (String name : advName) {
            if (!name.equals(matcher.group(2))) {
                System.out.print(advInCombat.get(name).beAttacked(adv, equName) + " ");
            }
        }
        System.out.println();
        String str = matcher.group(1) + " " + matcher.group(2) + " AOE-attacked with " + equName;
        log.addLog(str);
    }

    public void help() {
        for (int i = 0; i < people; i++) {
            Adventure adv = advInCombat.get(advName.get(i));
            adv.help(startHp.get(i));
        }
    }
}
