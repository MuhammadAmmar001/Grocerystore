import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests the functionality of opening dynamic search interfaces for different item categories.
 * Ensures that the dynamic search interface displays the correct initial titles and input placeholders.
 */
public class menuWithDynamicSearchTest {

    /**
     * Tests opening the dynamic search interface for crockery items.
     * Verifies that the title and input placeholder are correctly set.
     */
    @Test
    public void testOpenDynamicSearchWithCrockeryItems() {
        MENU menu = new MENU();
        menu.menu.setVisible(true);
        menu.crockery.doClick();
        dynamic_search dynamicSearch = new dynamic_search("crockery");
        assertEquals("Search an item to order", dynamicSearch.Title.getText());
        assertEquals("ENTER PRODUCT NAME", dynamicSearch.searchItem.getText());
    }

    /**
     * Tests opening the dynamic search interface for food items.
     * Verifies that the title and input placeholder are correctly set.
     */
    @Test
    public void testOpenDynamicSearchWithFoodItems() {
        MENU menu = new MENU();
        menu.menu.setVisible(true);
        menu.food.doClick();
        dynamic_search dynamicSearch = new dynamic_search("food");
        assertEquals("Search an item to order", dynamicSearch.Title.getText());
        assertEquals("ENTER PRODUCT NAME", dynamicSearch.searchItem.getText());
    }
}
