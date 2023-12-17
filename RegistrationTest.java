import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    @Test
    public void testEmptyNameField() {
        Registration frame = new Registration();
        frame.nameTextField.setText("");
        frame.mobileTextField.setText("12345567890");
        frame.passwordField.setText("*passworD123");
        frame.termsCheckBox.setSelected(true);
        frame.submitButton.doClick();

        assertEquals("Please enter your name.",
                frame.resultTextArea.getText());
    }

    @Test
    public void testInvalidMobileNumber() {
        Registration frame = new Registration();
        frame.nameTextField.setText("John Doe");
        frame.mobileTextField.setText("4a4");
        frame.passwordField.setText("password123");
        frame.termsCheckBox.setSelected(true);
        frame.submitButton.doClick();

        assertEquals("Please enter a valid 11-digit mobile number.", frame.resultTextArea.getText());
    }

    @Test
    public void testEmptyPasswordField() {
        Registration frame = new Registration();
        frame.nameTextField.setText("John Doe");
        frame.passwordField.setText("");
        frame.mobileTextField.setText("12345678922");
        frame.termsCheckBox.setSelected(true);
        frame.submitButton.doClick();

        assertEquals(
                "Please enter a strong password (at least 8 characters with uppercase, lowercase, and a special character).",
                frame.resultTextArea.getText());
    }

    @Test
    public void testEmptyAddress() {
        Registration frame = new Registration();
        frame.nameTextField.setText("John Doe");
        frame.mobileTextField.setText("12345678390");
        frame.passwordField.setText("passwD@ord123");
        frame.termsCheckBox.setSelected(true);
        frame.submitButton.doClick();

        assertEquals("Please enter your address.", frame.resultTextArea.getText());
    }

    @Test
    public void testTermsNotAccepted() {
        Registration frame = new Registration();
        frame.nameTextField.setText("John Doe");
        frame.passwordField.setText("@45aDssd5");
        frame.addressTextArea.setText("123 Main Street");

        frame.mobileTextField.setText("12345678922");
        frame.submitButton.doClick();

        assertEquals("Please accept the terms and conditions.", frame.resultTextArea.getText());
    }

    @Test
    public void testSuccessfulRegistration() {
        Registration frame = new Registration();
        frame.nameTextField.setText("John Doe");
        frame.mobileTextField.setText("12345678890");
        frame.maleRadioButton.setSelected(true);
        frame.dateComboBox.setSelectedIndex(1);
        frame.monthComboBox.setSelectedIndex(5);
        frame.yearComboBox.setSelectedIndex(10);
        frame.addressTextArea.setText("123 Main Street");
        frame.passwordField.setText("pass@5Sword123");
        frame.termsCheckBox.setSelected(true);
        frame.submitButton.doClick();

        assertTrue(frame.resultTextArea.getText().contains("Registration Successfully.."));
    }

    @Test
    public void testResetForm() {
        Registration frame = new Registration();
        frame.nameTextField.setText("John Doe");
        frame.mobileTextField.setText("1234567890");
        frame.resetButton.doClick();

        assertEquals("", frame.nameTextField.getText());
        assertEquals("", frame.mobileTextField.getText());
        assertEquals("", frame.resultTextArea.getText());
    }
}
