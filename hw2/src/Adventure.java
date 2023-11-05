import java.util.HashMap;

public class Adventure {
    private int id;
    private String name;
    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
    }

    public void addBottle(int id, String name, int capacity) {
        Bottle newBottle = new Bottle(id, name, capacity);
        bottles.put(id, newBottle);
    }

    public void removeBottle(int id) {
        String name = bottles.get(id).getName();
        bottles.remove(id, bottles.get(id));
        System.out.println(bottles.size() + " " + name);
    }

    public void addEquipment(int id, String name, int star) {
        Equipment newEquipment = new Equipment(id, name, star);
        equipments.put(id, newEquipment);
    }

    public void removeEquipment(int id) {
        String name = equipments.get(id).getName();
        equipments.remove(id, equipments.get(id));
        System.out.println(equipments.size() + " " + name);
    }

    public int upStar(int id) {
        Equipment update = equipments.get(id);
        return update.starUp();
    }
}
