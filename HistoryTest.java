import org.junit.Test;
import org.junit.Assert;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test class for testing the functionality of the History class.
 */
public class HistoryTest {

    /**
     * Test case to verify if the record file is read correctly and displayed in the JTextArea.
     *
     * @throws FileNotFoundException if the record file is not found.
     */
    @Test
    public void testRecordFileRead() throws FileNotFoundException {
        // Instantiate the history class
        history history = new history();

        // Read the expected content from the record file
        String expectedRecord = "";
        Scanner scanner = new Scanner(
                new File("D:\\NUST\\Semester 5\\SOFTWARE CONSTRUCTION\\Project\\grocerystore\\src\\record.txt"));
        while (scanner.hasNextLine()) {
            expectedRecord += scanner.nextLine() + "\n";
        }
        scanner.close();

        // Assert if the content displayed in the JTextArea matches the expected content
        Assert.assertEquals(expectedRecord, history.RECORD.getText());
    }

    /**
     * Test case to verify the functionality of the back button.
     *
     * @throws FileNotFoundException if the record file is not found.
     */
    @Test
    public void testBackButtonClick() throws FileNotFoundException {
        // Instantiate the history class
        history history = new history();

        // Simulate a click on the back button
        history.back.doClick();

        // Assert if the history window is not visible after the back button click
        Assert.assertFalse(history.hist.isVisible());
    }
}
