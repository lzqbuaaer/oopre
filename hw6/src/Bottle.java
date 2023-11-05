public class Bottle {
    private int id;
    private String name;
    private int capacity;
    private long price;
    private String type;

    public Bottle(int newID, String newName, int newCapacity, long newPrice, String newType) {
        this.id = newID;
        this.name = newName;
        this.capacity = newCapacity;
        this.price = newPrice;
        this.type = newType;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setZero() {
        this.capacity = 0;
    }

    public int use(int hitPoint) {
        return hitPoint + capacity;
    }

    public long getPrice() {
        return this.price;
    }
}
