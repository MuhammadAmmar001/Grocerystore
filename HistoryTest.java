import org.junit.Test;
import org.junit.Assert;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test class to validate functionalities of the History class.
 */
public class HistoryTest {

    /**
     * Test case to verify the reading of the record file and its content display.
     * - Creates a history object to read and display the record file content.
     * - Compares the content displayed in the JTextArea with the expected content
     * read from the file.
     *
     * @throws FileNotFoundException if the record file is not found.
     */
    @Test
    public void testRecordFileRead() throws FileNotFoundException {
        history history = new history();
        String expectedRecord = "";
        Scanner scanner = new Scanner(new File("D:\\NUST\\Semester 5\\SOFTWARE CONSTRUCTION\\Project\\grocerystore\\src\\record.txt"));
        while (scanner.hasNextLine()) {
            expectedRecord += scanner.nextLine() + "\n";
        }
        scanner.close();
        Assert.assertEquals(expectedRecord, history.RECORD.getText());
    }

    /**
     * Test case to verify the functionality of the back button click.
     * - Creates a history object.
     * - Simulates a click on the back button.
     * - Verifies if the history window is no longer visible after the click.
     *
     * @throws FileNotFoundException if the record file is not found.
     */
    @Test
    public void testBackButtonClick() throws FileNotFoundException {
        history history = new history();
        history.back.doClick();
        Assert.assertFalse(history.hist.isVisible());
    }

}
