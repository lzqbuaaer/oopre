import java.util.ArrayList;

public class CombatLog {
    private int people;
    private ArrayList<String> advName;
    private ArrayList<String> log;

    public CombatLog(ArrayList<ArrayList<String>> input, int i) {
        this.people = Integer.parseInt(input.get(i).get(1));
        this.advName = new ArrayList<>();
        for (int j = 0; j < people; j++) {
            String name = input.get(i).get(j + 3);
            advName.add(name);
        }
        this.log = new ArrayList<>();
    }

    public void addLog(String order) {
        log.add(order);
    }

    public boolean printTime(String time) {
        boolean flag = false;
        for (String order : log) {
            String[] strs = order.split(" +");
            if (time.equals(strs[0])) {
                System.out.println(order);
                flag = true;
            }
        }
        return flag;
    }

    public boolean printAttack(String name) {
        boolean flag = false;
        if (advName.contains(name)) {
            for (String order : log) {
                String[] strs = order.split(" +");
                if (name.equals(strs[1]) && !strs[2].equals("used")) {
                    System.out.println(order);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean printBeAttacked(String name) {
        boolean flag = false;
        if (advName.contains(name)) {
            for (String order : log) {
                String[] strs = order.split(" +");
                if (name.equals(strs[3]) && strs[2].equals("attacked")) {
                    System.out.println(order);
                    flag = true;
                } else if (strs[2].equals("AOE-attacked") && !name.equals(strs[1])) {
                    System.out.println(order);
                    flag = true;
                }
            }
        }
        return flag;
    }
}
