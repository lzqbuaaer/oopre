import java.util.HashMap;
import java.util.Map;

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
    private HashMap<Integer, Adventure> employ;

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
        this.employ = new HashMap<>();
    }

    public int getId() {
        return this.id;
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

    public int getLevel() {
        return this.level;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public void addBottle(int id, String name, int capacity, long price, String type, String rat) {
        if (type.equals("RegularBottle")) {
            Bottle newBottle = new Bottle(id, name, capacity, price, type);
            bottles.put(id, newBottle);
        } else if (type.equals("ReinforcedBottle")) {
            ReinforcedBottle newBottle = new ReinforcedBottle(id, name, capacity, price, type);
            newBottle.setRatio(Double.parseDouble(rat));
            bottles.put(id, newBottle);
        } else {
            RecoverBottle newBottle = new RecoverBottle(id, name, capacity, price, type);
            newBottle.setRatio(Double.parseDouble(rat));
            bottles.put(id, newBottle);
        }
    }

    public String removeBottle(int id) {
        String name = bottles.get(id).getName();
        bottles.remove(id, bottles.get(id));
        bag.removeBottle(name, id);
        System.out.println(bottles.size() + " " + name);
        return name;
    }

    public void addEquipment(int id, String name, int star, long price, String type, String other) {
        if (type.equals("RegularEquipment")) {
            Equipment newEquipment = new Equipment(id, name, star, price, type);
            equipments.put(id, newEquipment);
        } else if (type.equals("CritEquipment")) {
            CritEquipment newEquipment = new CritEquipment(id, name, star, price, type);
            newEquipment.setCritical(Integer.parseInt(other));
            equipments.put(id, newEquipment);
        } else {
            EpicEquipment newEquipment = new EpicEquipment(id, name, star, price, type);
            newEquipment.setRatio(Double.parseDouble(other));
            equipments.put(id, newEquipment);
        }
    }

    public String removeEquipment(int id) {
        String name = equipments.get(id).getName();
        equipments.remove(id, equipments.get(id));
        System.out.println(equipments.size() + " " + name);
        bag.removeEqu(name, id);
        return name;
    }

    public int upStar(int id) {
        Equipment update = equipments.get(id);
        return update.starUp();
    }

    public void addFood(int id, String name, int energy, long price) {
        Food newFood = new Food(id, name, energy, price);
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
        this.bag.addEqument(id, equ.getName());
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
                hitPoint = bottles.get(removeId).use(hitPoint);
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

    public boolean findBottleInBag(String name) {
        return bag.findBottle(name);
    }

    public boolean findEquInBag(String name) {
        return bag.findEqument(name);
    }

    public Equipment getEquInBag(String name) {
        int id = bag.getEqu(name);
        return equipments.get(id);
    }

    public int beAttacked(Adventure adv, String equName) {
        int level = adv.getLevel();
        this.hitPoint = adv.getEquInBag(equName).use(this.hitPoint, level);
        return this.hitPoint;
    }

    public void employAdv(Adventure adv) {
        int advId = adv.getId();
        if (!employ.containsKey(advId)) {
            employ.put(advId, adv);
        }
    }

    public int countCommodity() {
        int num = bottles.size() + foods.size() + equipments.size() + employ.size();
        return num;
    }

    public long sumPrice() {
        long sum = 0;
        for (Map.Entry<Integer, Bottle> bot : bottles.entrySet()) {
            sum += bot.getValue().getPrice();
        }
        for (Map.Entry<Integer, Equipment> equ : equipments.entrySet()) {
            sum += equ.getValue().getPrice();
        }
        for (Map.Entry<Integer, Food> food : foods.entrySet()) {
            sum += food.getValue().getPrice();
        }
        for (Map.Entry<Integer, Adventure> adv : employ.entrySet()) {
            sum += adv.getValue().sumPrice();
        }
        return sum;
    }

    public long maxPrice() {
        long max = 0;
        for (Map.Entry<Integer, Bottle> bot : bottles.entrySet()) {
            long sum = bot.getValue().getPrice();
            if (max < sum) {
                max = sum;
            }
        }
        for (Map.Entry<Integer, Equipment> equ : equipments.entrySet()) {
            long sum = equ.getValue().getPrice();
            if (max < sum) {
                max = sum;
            }
        }
        for (Map.Entry<Integer, Food> food : foods.entrySet()) {
            long sum = food.getValue().getPrice();
            if (max < sum) {
                max = sum;
            }
        }
        for (Map.Entry<Integer, Adventure> adv : employ.entrySet()) {
            long sum = adv.getValue().sumPrice();
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public String findClassName(int id) {
        if (bottles.containsKey(id)) {
            Bottle bot = bottles.get(id);
            if (bot instanceof ReinforcedBottle) {
                return "ReinforcedBottle";
            } else if (bot instanceof RecoverBottle) {
                return "RecoverBottle";
            } else {
                return "RegularBottle";
            }
        } else if (equipments.containsKey(id)) {
            Equipment equ = equipments.get(id);
            if (equ instanceof CritEquipment) {
                return "CritEquipment";
            } else if (equ instanceof EpicEquipment) {
                return "EpicEquipment";
            } else {
                return "RegularEquipment";
            }
        } else if (foods.containsKey(id)) {
            return "Food";
        } else {
            return "Adventurer";
        }
    }
}
