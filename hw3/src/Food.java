public class Food {
    private int id;
    private String name;
    private int energy;

    public Food(int newId, String newName, int newEnergy) {
        this.id = newId;
        this.name = newName;
        this.energy = newEnergy;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
    }
}
