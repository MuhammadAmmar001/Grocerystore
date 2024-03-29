import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import javax.swing.ListModel;
import org.junit.Assert;

/**
 * Contains a suite of system-level tests that validate end-to-end functionality
 * by simulating user actions and verifying different parts of the application.
 */
public class systemTesting {

    /**
     * Simulates user registration, login, item search, cart management,
     * and shopping history display to validate the overall system behavior.
     */
    @Test
    public void testRegisterUser() {

        // Initializing Registration frame with user details
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

        // Validating successful registration
        assertTrue(frame.resultTextArea.getText().contains("Registration Successfully.."));

        LoginFrame loginFrame = new LoginFrame();

        // Simulate user input with invalid credentials
        loginFrame.userTextField.setText("amna");
        loginFrame.passwordField.setText("11223344");

        // Trigger the login action
        loginFrame.loginButton.doClick();

        // Assert that the status label indicates wrong password
        assertEquals("SUCCESSFULLY LOGGED IN", loginFrame.pwdRes.getText());

        MENU menu = new MENU();
        menu.menu.setVisible(true);

        menu.food.doClick();

        dynamic_search dynamicSearch = new dynamic_search("vegetables");

        dynamicSearch.search.setText("tomato");
        dynamicSearch.submit.doClick();

        // Verifying if the search result contains the expected item "tomato"
        ListModel<String> listModel = dynamicSearch.available_items.getModel();
        int size = listModel.getSize();
        String[] listedItems = new String[size];

        for (int i = 0; i < size; i++) {
            listedItems[i] = listModel.getElementAt(i);
        }

        Assert.assertTrue(Arrays.stream(listedItems).anyMatch(item -> item.contains("tomato")));

        dynamicSearch.addcart.doClick();

        menu.cart.doClick();

        // Accessing and validating shopping history display
        try {
            manage_cart manageCart = new manage_cart();
            manageCart.proceed_order.doClick();
            assertEquals("Rs.1270 is your total bill", manageCart.Totalbill.getText());
            history history = new history();
            assertEquals("SHOPING HISTORY", history.hist.getTitle());
        } catch (Exception e) {
        }
    }
}
