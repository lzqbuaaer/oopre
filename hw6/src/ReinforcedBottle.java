public class ReinforcedBottle extends Bottle {
    private double ratio;

    public ReinforcedBottle(int newID, String newName, int newCapacity,
                            long newPrice, String newType) {
        super(newID, newName, newCapacity, newPrice, newType);
    }

    public void setRatio(double rat) {
        this.ratio = rat;
    }

    @Override
    public int use(int hitPoint) {
        return (int) (hitPoint + (1 + ratio) * super.getCapacity());
    }
}
