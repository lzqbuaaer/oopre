import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class AdventureTest {

    @Test
    public void addBottle() {
    }

    @Test
    public void removeBottle() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Adventure tAdv=new Adventure(159,"test");
        tAdv.addBottle(12,"testBottle1",90);
        tAdv.addBottle(15,"testBottle2",90);
        tAdv.removeBottle(15);

        String consoleOutput = outputStream.toString().trim();
        assertEquals("1 testBottle2", consoleOutput);
        System.setOut(System.out);
    }

    @Test
    public void addEquipment() {
    }

    @Test
    public void removeEquipment() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Adventure tAdv=new Adventure(159,"test");
        tAdv.addEquipment(12,"testEqu1",3);
        tAdv.addEquipment(15,"testEqu2",4);
        tAdv.removeEquipment(12);

        String consoleOutput = outputStream.toString().trim();
        assertEquals("1 testEqu1", consoleOutput);
        System.setOut(System.out);
    }

    @Test
    public void upStar() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Adventure tAdv=new Adventure(159,"test");
        tAdv.addEquipment(12,"testEqu1",3);
        tAdv.upStar(12);

        String consoleOutput = outputStream.toString().trim();
        assertEquals("testEqu1 4", consoleOutput);
        System.setOut(System.out);
    }
}