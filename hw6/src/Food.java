public class Food {
    private int id;
    private String name;
    private int energy;
    private long price;

    public Food(int newId, String newName, int newEnergy, long newPrice) {
        this.id = newId;
        this.name = newName;
        this.energy = newEnergy;
        this.price = newPrice;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public long getPrice() {
        return this.price;
    }
}
