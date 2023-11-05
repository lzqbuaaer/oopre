public class Equipment {
    private int id;
    private String name;
    private int star;

    public Equipment(int id, String name, int star) {
        this.id = id;
        this.name = name;
        this.star = star;
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

}
