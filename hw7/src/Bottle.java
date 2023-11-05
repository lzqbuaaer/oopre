public class Bottle implements Goods {
    private int id;
    private String name;
    private int capacity;
    private long price;
    private String type;
    private int fullCapacity;

    public Bottle(int newID, String newName, int newCapacity, long newPrice, String newType) {
        this.id = newID;
        this.name = newName;
        this.capacity = newCapacity;
        this.price = newPrice;
        this.type = newType;
        this.fullCapacity = newCapacity;
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

    @Override
    public boolean equal(String type, String other) {
        return type.endsWith("Bottle");
    }

    @Override
    public int getSize() {
        return this.fullCapacity;
    }
}
