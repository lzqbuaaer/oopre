import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Bag {
    private HashMap<String, Integer> equName;
    private HashMap<String, TreeSet<Integer>> bottleSet;
    private HashMap<String, TreeSet<Integer>> foodSet;

    public Bag() {
        this.equName = new HashMap<>();
        this.bottleSet = new HashMap<>();
        this.foodSet = new HashMap<>();
    }

    public void addEqument(int id, String name) {
        equName.remove(name);
        equName.put(name, id);
    }

    public boolean findEqument(String name) {
        return equName.containsKey(name);
    }

    public boolean findBottle(String name) {
        return bottleSet.containsKey(name) && !bottleSet.get(name).isEmpty();
    }

    public int bottleSize(String name) {
        if (!bottleSet.containsKey(name)) {
            return 0;
        } else {
            return bottleSet.get(name).size();
        }
    }

    public void createBottle(String name, int id) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(id);
        bottleSet.put(name, tree);
    }

    public void addBottle(String name, int id) {
        bottleSet.get(name).add(id);
    }

    public boolean findFood(String name) {
        return foodSet.containsKey(name) && !foodSet.get(name).isEmpty();
    }

    public void createFood(String name, int id) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(id);
        foodSet.put(name, tree);
    }

    public void addFood(String name, int id) {
        if (!foodSet.containsKey(name)) {
            createFood(name, id);
        } else {
            foodSet.get(name).add(id);
        }
    }

    public int useBottle(String name) {
        if (bottleSet.containsKey(name) && (!(bottleSet.get(name).isEmpty()))) {
            int removeId = bottleSet.get(name).first();
            return removeId;
        } else {
            System.out.println("fail to use " + name);
            return -1;
        }
    }

    public void removeBottle(String name, int id) {
        if (bottleSet.containsKey(name)) {
            bottleSet.get(name).remove(id);
        }
    }

    public int useFood(String name) {
        if (foodSet.containsKey(name) && !foodSet.get(name).isEmpty()) {
            int removeId = foodSet.get(name).first();
            foodSet.get(name).remove(removeId);
            return removeId;
        } else {
            System.out.println("fail to eat " + name);
            return -1;
        }
    }

    public void removeFood(String name, int id) {
        if (foodSet.containsKey(name)) {
            foodSet.get(name).remove(id);
        }
    }

    public int getEqu(String name) {
        return equName.get(name);
    }

    public void removeEqu(String name, int id) {
        equName.remove(name, id);
    }

    public long countPrice(HashMap<Integer, Bottle> bots,
                           HashMap<Integer, Equipment> equs, HashMap<Integer, Food> foods) {
        long sum = 0;
        for (Map.Entry<String, TreeSet<Integer>> bot : bottleSet.entrySet()) {
            TreeSet<Integer> botTree = bot.getValue();
            for (int id : botTree) {
                Bottle bottle = bots.get(id);
                sum += bottle.getPrice();
                bots.remove(id, bottle);
                Shop.getInstance().addLog(bottle);
            }
        }
        for (Map.Entry<String, Integer> equ : equName.entrySet()) {
            int id = equ.getValue();
            Equipment eq = equs.get(id);
            sum += eq.getPrice();
            equs.remove(id, eq);
            Shop.getInstance().addLog(eq);
        }
        for (Map.Entry<String, TreeSet<Integer>> food : foodSet.entrySet()) {
            TreeSet<Integer> foodTree = food.getValue();
            for (int id : foodTree) {
                Food fd = foods.get(id);
                sum += fd.getPrice();
                foods.remove(id, fd);
                Shop.getInstance().addLog(fd);
            }
        }
        return sum;
    }

    public void clear() {
        bottleSet.clear();
        equName.clear();
        foodSet.clear();
        ;
    }
}


