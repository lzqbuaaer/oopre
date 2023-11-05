public class RecoverBottle extends Bottle {
    private double ratio;

    public RecoverBottle(int newID, String newName, int newCapacity,
                         long newPrice, String newType) {
        super(newID, newName, newCapacity, newPrice, newType);
    }

    public void setRatio(double rat) {
        this.ratio = rat;
    }

    @Override
    public int use(int hitPoint) {
        return (hitPoint + (int) (hitPoint * ratio));
    }
}
