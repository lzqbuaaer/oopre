public class EpicEquipment extends Equipment {
    private double ratio;

    public EpicEquipment(int id, String name, int star, long price, String type) {
        super(id, name, star, price, type);
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public int use(int hitPoint, int level) {
        return (hitPoint - (int) (hitPoint * ratio));
    }
}