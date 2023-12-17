import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class menuWithDynamicSearchTest {
    @Test
    public void testOpenDynamicSearchWithCrockeryItems() {
        MENU menu = new MENU();
        menu.menu.setVisible(true);

        menu.crockery.doClick();

        dynamic_search dynamicSearch = new dynamic_search("crockery");

        assertEquals("Search an item to order", dynamicSearch.Title.getText());
        assertEquals("ENTER PRODUCT NAME", dynamicSearch.searchItem.getText());
    }

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
