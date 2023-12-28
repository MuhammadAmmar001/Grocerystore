import org.junit.Assert;
import org.junit.Test;

/**
 * Test class to validate the functionality of the Menu visibility.
 */
public class MenuTest {

    /**
     * Tests whether the Menu window is visible after instantiation.
     */
    @Test
    public void testMenuVisibility() {
        // Instantiates a Menu object
        MENU menu = new MENU();

        // Asserts that the Menu window is visible
        Assert.assertTrue(menu.menu.isVisible());
    }
}
