import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * Test class for validating the LoginFrame's login functionality.
 */
public class LoginTest {

    /**
     * Test case to validate login with valid credentials.
     */
    @Test
    public void testLoginWithValidCredentials() {
        // Create an instance of LoginFrame
        LoginFrame loginFrame = new LoginFrame();

        // Simulate user input with valid credentials
        loginFrame.userTextField.setText("amna");
        loginFrame.passwordField.setText("11223344");

        // Trigger the login action
        loginFrame.loginButton.doClick();

        // Assert that the status label indicates successful login
        assertEquals("SUCCESSFULLY LOGGED IN", loginFrame.pwdRes.getText());
    }

    /**
     * Test case to validate login with invalid credentials.
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
