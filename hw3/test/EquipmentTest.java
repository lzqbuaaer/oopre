import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void starUp() {
        Equipment equ = new Equipment(123, "sword", 2);
        assertEquals(equ.starUp(), 3);
    }

    @Test
    public void getName() {
        Equipment equ = new Equipment(123, "sword", 2);
        assertEquals(equ.getName(), "sword");
    }
}