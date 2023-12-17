import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class loginWithRegTest {

    @Test
    public void testSuccessfulRegistrationLogin() throws Exception {
        // Initialize LoginFrame and Registration
        LoginFrame loginFrame = new LoginFrame();
        Registration registration = new Registration();

        // Simulate user registration
        registration.nameTextField.setText("John Doe");
        registration.mobileTextField.setText("12345679890");
        registration.passwordField.setText("StrongPassword123!");
        registration.addressTextArea.setText("123 Main Street");
        registration.maleRadioButton.setSelected(true);
        registration.termsCheckBox.setSelected(true);
        registration.submitButton.doClick();

        // Verify registration success
        assertEquals("Registration Successfully..", registration.resultTextArea.getText());

        // Simulate login with registered credentials
        loginFrame.userTextField.setText("John Doe");
        loginFrame.passwordField.setText("StrongPassword123!");
        loginFrame.loginButton.doClick();

        assertEquals("SUCCESSFULLY LOGGED IN", loginFrame.pwdRes.getText());
    }

    @Test
    public void testInvalidPasswordLogin() throws Exception {
        LoginFrame loginFrame = new LoginFrame();

        // Simulate user login with incorrect password
        loginFrame.userTextField.setText("John Doe");
        loginFrame.passwordField.setText("WrongPassword");
        loginFrame.loginButton.doClick();

        // Verify login failure
        assertEquals("WRONG PASSWORD", loginFrame.pwdRes.getText());

    }

}