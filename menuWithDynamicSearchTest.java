import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test class to validate the interaction between MENU and Dynamic Search for specific items.
 */
public class menuWithDynamicSearchTest {

    /**
     * Tests the opening of Dynamic Search for Crockery items from the MENU.
     */
    @Test
    public void testOpenDynamicSearchWithCrockeryItems() {
        // Instantiates a Menu object
        MENU menu = new MENU();
        
        // Makes the Menu window visible
        menu.menu.setVisible(true);
        
        // Simulates clicking the Crockery button in the Menu
        menu.crockery.doClick();
        
        // Verifies the Dynamic Search window's expected initial state for Crockery
        dynamic_search dynamicSearch = new dynamic_search("crockery");
        assertEquals("Search an item to order", dynamicSearch.Title.getText());
        assertEquals("ENTER PRODUCT NAME", dynamicSearch.searchItem.getText());
    }

    /**
     * Tests the opening of Dynamic Search for Food items from the MENU.
     */
    @Test
    public void testOpenDynamicSearchWithFoodItems() {
        // Instantiates a Menu object
        MENU menu = new MENU();
        
        // Makes the Menu window visible
        menu.menu.setVisible(true);
        
        // Simulates clicking the Food button in the Menu
        menu.food.doClick();
        
        // Verifies the Dynamic Search window's expected initial state for Food
        dynamic_search dynamicSearch = new dynamic_search("food");
        assertEquals("Search an item to order", dynamicSearch.Title.getText());
        assertEquals("ENTER PRODUCT NAME", dynamicSearch.searchItem.getText());
    }
}
