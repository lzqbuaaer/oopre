import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Bag {
    private HashSet<String> equName;
    private HashMap<String, TreeSet<Integer>> bottleSet;
    private HashMap<String, TreeSet<Integer>> foodSet;

    public Bag() {
        this.equName = new HashSet<>();
        this.bottleSet = new HashMap<>();
        this.foodSet = new HashMap<>();
    }

    public void addEqument(String name) {
        equName.add(name);
    }

    public boolean findEqument(String name) {
        return equName.contains(name);
    }

    public boolean findBottle(String name) {
        return bottleSet.containsKey(name);
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
        return foodSet.containsKey(name);
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
}


