import java.util.ArrayList;

public class Shop {
    private static Shop shop = new Shop();
    private static ArrayList<Goods> log;

    private Shop() {
        log = new ArrayList<>();
    }

    public static Shop getInstance() {
        return shop;
    }

    public void addLog(Goods goods) {
        log.add(goods);
    }

    public Goods buy(int id, String name, String type, String others) {
        long price = 0;
        int size = 0;
        int num = 0;
        for (Goods goods : log) {
            if (goods.equal(type, others)) {
                num++;
                price += goods.getPrice();
                size += goods.getSize();
            }
        }
        price /= num;
        size /= num;
        if (type.equals("Food")) {
            Food need = new Food(id, name, size, price);
            return need;
        } else if (type.equals("RegularBottle")) {
            Bottle need = new Bottle(id, name, size, price, type);
            return need;
        } else if (type.equals("RecoverBottle")) {
            RecoverBottle need = new RecoverBottle(id, name, size, price, type);
            need.setRatio(Double.parseDouble(others));
            return need;
        } else if (type.equals("ReinforcedBottle")) {
            ReinforcedBottle need = new ReinforcedBottle(id, name, size, price, type);
            need.setRatio(Double.parseDouble(others));
            return need;
        } else if (type.equals("RegularEquipment")) {
            Equipment need = new Equipment(id, name, size, price, type);
            return need;
        } else if (type.equals("EpicEquipment")) {
            EpicEquipment need = new EpicEquipment(id, name, size, price, type);
            need.setRatio(Double.parseDouble(others));
            return need;
        } else if (type.equals("CritEquipment")) {
            CritEquipment need = new CritEquipment(id, name, size, price, type);
            need.setCritical(Integer.parseInt(others));
            return need;
        } else {
            return null;
        }
    }
}
