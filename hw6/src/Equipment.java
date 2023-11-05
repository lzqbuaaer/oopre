public class Equipment {
    private int id;
    private String name;
    private int star;
    private long price;
    private String type;

    public Equipment(int id, String name, int star, long price, String type) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.price = price;
        this.type = type;
    }

    public int getStar() {
        return this.star;
    }

    public int starUp() {
        this.star += 1;
        System.out.println(this.name + " " + this.star);
        return this.star;
    }

    public String getName() {
        return this.name;
    }

    public int use(int hitPoint, int level) {
        return hitPoint - level * star;
    }

    public long getPrice() {
        return this.price;
    }
}
