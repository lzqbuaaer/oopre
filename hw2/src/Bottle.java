public class Bottle {
    private int id;
    private String name;
    private int capacity;

    public Bottle(int newID, String newName, int newCapacity) {
        this.id = newID;
        this.name = newName;
        this.capacity = newCapacity;
    }

    public String getName() {
        return this.name;
    }
}
