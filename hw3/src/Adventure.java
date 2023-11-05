import java.util.HashMap;

public class Adventure {
    private int id;
    private String name;
    private int hitPoint;
    private int level;
    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;
    private HashMap<Integer, Food> foods;
    private Bag bag;
    private int maxBottleInBag;

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.hitPoint = 500;
        this.level = 1;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
        this.foods = new HashMap<>();
        this.bag = new Bag();
        this.maxBottleInBag = 1 + this.level / 5;
    }

    public String getName() {
        return this.name;
    }

    public String getBottle(int id) {
        if (bottles.containsKey(id)) {
            return bottles.get(id).getName();
        } else {
            return null;
        }
    }

    public String getEquipment(int id) {
        if (equipments.containsKey(id)) {
            return equipments.get(id).getName();
        } else {
            return null;
        }
    }

    public String getFood(int id) {
        if (foods.containsKey(id)) {
            return foods.get(id).getName();
        } else {
            return null;
        }
    }

    public Bag getBag() {
        return this.bag;
    }

    public void addBottle(int id, String name, int capacity) {
        Bottle newBottle = new Bottle(id, name, capacity);
        bottles.put(id, newBottle);
    }

    public String removeBottle(int id) {
        String name = bottles.get(id).getName();
        bottles.remove(id, bottles.get(id));
        bag.removeBottle(name, id);
        System.out.println(bottles.size() + " " + name);
        return name;
    }

    public void addEquipment(int id, String name, int star) {
        Equipment newEquipment = new Equipment(id, name, star);
        equipments.put(id, newEquipment);
    }

    public String removeEquipment(int id) {
        String name = equipments.get(id).getName();
        equipments.remove(id, equipments.get(id));
        System.out.println(equipments.size() + " " + name);
        return name;
    }

    public int upStar(int id) {
        Equipment update = equipments.get(id);
        return update.starUp();
    }

    public void addFood(int id, String name, int energy) {
        Food newFood = new Food(id, name, energy);
        foods.put(id, newFood);
    }

    public String removeFood(int id) {
        String name = foods.get(id).getName();
        foods.remove(id, foods.get(id));
        bag.removeFood(name, id);
        System.out.println(foods.size() + " " + name);
        return name;
    }

    public String addEquipmentToBag(int id) {
        Equipment equ = equipments.get(id);
        this.bag.addEqument(equ.getName());
        return equ.getName();
    }

    public String addBottleToBag(int id) {
        String botName = bottles.get(id).getName();
        if (!bag.findBottle(botName)) {
            bag.createBottle(botName, id);
            return botName;
        } else if (maxBottleInBag > bag.bottleSize(botName)) {
            bag.addBottle(botName, id);
            return botName;
        } else {
            return null;
        }
    }

    public String addFoodToBag(int id) {
        String foodName = foods.get(id).getName();
        if (!bag.findFood(foodName)) {
            bag.createFood(foodName, id);
            return foodName;
        } else {
            bag.addFood(foodName, id);
            return foodName;
        }
    }

    public int useBottle(String name) {
        int removeId = bag.useBottle(name);
        if (removeId >= 0) {
            if (bottles.get(removeId).getCapacity() == 0) {
                bottles.remove(removeId, bottles.get(removeId));
                bag.removeBottle(name, removeId);
            } else {
                hitPoint += bottles.get(removeId).getCapacity();
                bottles.get(removeId).setZero();
            }
            System.out.println(removeId + " " + hitPoint);
            return hitPoint;
        } else {
            return -1;
        }
    }

    public int useFood(String name) {
        int removeId = bag.useFood(name);
        if (removeId >= 0) {
            level += foods.get(removeId).getEnergy();
            maxBottleInBag = 1 + level / 5;
            System.out.println(removeId + " " + level);
            foods.remove(removeId, foods.get(removeId));
            return level;
        } else {
            return -1;
        }
    }
}
