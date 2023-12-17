
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    @Test
    public void testEmptyNameField() {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.tname.setText("");
        frame.term.setSelected(true);
        frame.sub.doClick(); // Simulate button click
        assertEquals("Please enter your name", frame.res.getText());
    }

    @Test
    public void testInvalidMobileNumber() {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.tmno.setText("4a4");
        frame.tname.setText("abc");
        frame.tpassword.setText("abc");
        frame.term.setSelected(true);
        frame.sub.doClick();
        assertEquals("Please enter a valid mobile number", frame.res.getText());
    }

    @Test
    public void testEmptyPasswordField() {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.tname.setText("abc");
        frame.tpassword.setText("");
        frame.term.setSelected(true);
        frame.sub.doClick();
        assertEquals("Password cannot be empty", frame.res.getText()); // No error message unless clicked again
    }

    @Test
    public void testTermsNotAccepted() {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.sub.doClick();
        assertEquals("Please accept the terms & conditions..", frame.res.getText());
    }

    @Test
    public void testSuccessfulRegistration() {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.tname.setText("John Doe");
        frame.tmno.setText("1234567890");
        frame.male.setSelected(true);
        frame.date.setSelectedIndex(1);
        frame.month.setSelectedIndex(5);
        frame.year.setSelectedIndex(10);
        frame.tadd.setText("123 Main Street");
        frame.tpassword.setText("password123");
        frame.term.setSelected(true);
        frame.sub.doClick();

        assertEquals("Registration Successfully..", frame.res.getText());
        assertTrue(frame.tout.getText().contains("John Doe"));
        assertEquals(frame.getUserFile().exists(), true);
    }

    @Test
    public void testResetForm() {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.tname.setText("John Doe");
        frame.tmno.setText("1234567890");
        frame.reset.doClick();

        assertEquals("", frame.tname.getText());
        assertEquals("", frame.tmno.getText());
        assertEquals("", frame.tout.getText());
        assertEquals("", frame.res.getText());
    }

}
