import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void starUp() {
        Equipment equ = new Equipment(123, "sword", 2,10,"RegularEquipment");
        assertEquals(equ.starUp(), 3);
    }

    @Test
    public void getName() {
        Equipment equ = new Equipment(123, "sword", 2,10,"RegularEquipment");
        assertEquals(equ.getName(), "sword");
    }
    @Test
    public void getStar() {
        Equipment equ = new Equipment(123, "sword", 2,10,"RegularEquipment");
        assertEquals(equ.getStar(), 2);
    }

    @Test
    public void use() {
    }

    @Test
    public void getPrice() {
    }
}