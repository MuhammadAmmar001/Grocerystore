import org.junit.Assert;
import org.junit.Test;

public class MenuTest {

    @Test
    public void testMenuVisibility() {
        MENU menu = new MENU();

        Assert.assertTrue(menu.menu.isVisible());
    }

}
