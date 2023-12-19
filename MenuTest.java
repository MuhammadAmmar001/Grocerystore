import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the visibility of the MENU window.
 * Verifies that the MENU window is visible upon initialization.
 */
public class MenuTest {

    /**
     * Tests the visibility of the MENU window.
     * Verifies that the MENU window is visible upon initialization.
     */
    @Test
    public void testMenuVisibility() {
        MENU menu = new MENU();
        Assert.assertTrue(menu.menu.isVisible());
    }
}
