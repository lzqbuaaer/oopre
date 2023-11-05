import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTest {

    @Test
    public void getName() {
        Food food = new Food(123, "beef", 3);
        assertEquals(food.getName(), "beef");
    }

    @Test
    public void getEnergy() {
        Food food = new Food(123, "beef", 3);
        assertEquals(food.getEnergy(), 3);
    }
}