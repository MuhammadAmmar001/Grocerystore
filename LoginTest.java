import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * Test class to validate functionalities of the History class.
 */
public class LoginTest {

    /**
     * Test case to verify the reading of the record file and its content display.
     * - Creates a history object to read and display the record file content.
     * - Compares the content displayed in the JTextArea with the expected content read from the file.
     *
     * @throws FileNotFoundException if the record file is not found.
     */
    @Test
    public void testLoginWithValidCredentials() {
        // Create an instance of LoginFrame
        LoginFrame loginFrame = new LoginFrame();

        // Simulate user input
        loginFrame.userTextField.setText("amna");
        loginFrame.passwordField.setText("11223344");

        // Trigger the login action
        loginFrame.loginButton.doClick();

        // Assert that the status label indicates successful login
        assertEquals("SUCCESSFULLY LOGGED IN", loginFrame.pwdRes.getText());
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
    public void testLoginWithInvalidCredentials() {
        // Create an instance of LoginFrame
        LoginFrame loginFrame = new LoginFrame();

        // Simulate user input with invalid credentials
        loginFrame.userTextField.setText("abc");
        loginFrame.passwordField.setText("000");

        // Trigger the login action
        loginFrame.loginButton.doClick();

        // Assert that the status label indicates wrong password
        assertEquals("WRONG PASSWORD", loginFrame.pwdRes.getText());
    }
}
