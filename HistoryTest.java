import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HistoryTest {

    @Test
    public void testRecordFileRead() throws FileNotFoundException {
        history history = new history();

        String expectedRecord = "";
        Scanner scanner = new Scanner(
                new File("D:\\NUST\\Semester 5\\SOFTWARE CONSTRUCTION\\Project\\grocerystore\\src\\record.txt"));
        while (scanner.hasNextLine()) {
            expectedRecord += scanner.nextLine() + "\n";
        }
        scanner.close();

        Assert.assertEquals(expectedRecord, history.RECORD.getText());
    }

    @Test
    public void testBackButtonClick() throws FileNotFoundException {
        history history = new history();

        history.back.doClick();

        Assert.assertFalse(history.hist.isVisible());
    }

}
