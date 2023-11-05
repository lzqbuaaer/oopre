import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void starUp() {
        //Redirecting console output to a byte array output stream.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Equipment tEqu = new Equipment(456, "test", 3);
        tEqu.starUp();

        //Retrieve the content of the console output.
        String consoleOutput = outputStream.toString().trim();

        assertEquals("test 4", consoleOutput);
        //Restore the console output.
        System.setOut(System.out);
    }

    @Test
    public void getName() {
        Equipment tEqu = new Equipment(456, "test", 3);
        assert (tEqu.getName().equals("test"));
    }
}