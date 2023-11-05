import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void getInstance() {
    }

    @Test
    public void addLog() {
    }

    @Test
    public void buy() {
        Bottle bot1 = new Bottle(123, "test1", 80,10,"RegularBottle");
        RecoverBottle bot2 = new RecoverBottle(124, "test2", 80,20,"RecoverBottle");
        bot2.setRatio(0.5);
        ReinforcedBottle bot3 = new ReinforcedBottle(125, "test3", 80,30,"ReinforcedBottle");
        bot3.setRatio(0.5);
        Equipment equ1 = new Equipment(23, "sword1", 2,40,"RegularEquipment");
        CritEquipment equ2 = new CritEquipment(24, "sword2", 2,50,"CritEquipment");
        equ2.setCritical(100);
        EpicEquipment equ3 = new EpicEquipment(25, "sword3", 2,60,"EpicEquipment");
        equ3.setRatio(0.5);
        Food food = new Food(12, "beef", 3, 70);
        Shop.getInstance().addLog(bot1);
        Shop.getInstance().addLog(bot2);
        Shop.getInstance().addLog(bot3);
        Shop.getInstance().addLog(equ1);
        Shop.getInstance().addLog(equ2);
        Shop.getInstance().addLog(equ3);
        Shop.getInstance().addLog(food);
        Goods g1 = Shop.getInstance().buy(1,"name","RegularBottle",null);
        Goods g2 = Shop.getInstance().buy(1,"name","RecoverBottle","0.5");
        Goods g3 = Shop.getInstance().buy(1,"name","ReinforcedBottle","0.5");
        Goods g4 = Shop.getInstance().buy(1,"name","RegularEquipment",null);
        Goods g5 = Shop.getInstance().buy(1,"name","CritEquipment","100");
        Goods g6 = Shop.getInstance().buy(1,"name","EpicEquipment","0.5");
        Goods g7 = Shop.getInstance().buy(1,"name","Food",null);
    }
}