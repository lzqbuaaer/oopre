public class CritEquipment extends Equipment {
    private int critical;

    public CritEquipment(int id, String name, int star, long price, String type) {
        super(id, name, star, price, type);
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    @Override
    public int use(int hitPoint, int level) {
        return hitPoint - level * super.getStar() - critical;
    }
}
