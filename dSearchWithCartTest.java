import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.Test;

/**
 * Test class to validate the functionality of adding and removing items to/from
 * the cart.
 */
public class dSearchWithCartTest {

    /**
     * Test case to verify adding a "spoon" item to the cart.
     * - Searches for a spoon in crockery using dynamic_search.
     * - Clicks to add the found spoon to the cart.
     * - Verifies if "spoon" is found in the cart file.
     */
    @Test
    public void testAddSpoonToCart() {
        dynamic_search ds = new dynamic_search("crockery");
        ds.search.setText("spoon");
        ds.submit.doClick();
        ds.available_items.setSelectedIndex(0);
        ds.addcart.doClick();
        File cartItems = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\cart.txt");
        try {
            Scanner read = new Scanner(cartItems);
            boolean found = false;
            while (read.hasNextLine()) {
                if (read.nextLine().contains("spoon")) {
                    found = true;
                    break;
                }
            }
            assertTrue(found);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test case to verify removing a "spoon" item from the cart.
     * - Searches for a spoon in crockery using dynamic_search.
     * - Adds the found spoon to the cart.
     * - Proceeds to manage the cart and remove the spoon.
     * - Verifies that "spoon" is no longer in the cart.
     */
    @Test
    public void testRemoveSpoonFromCart() {
        dynamic_search dynamicSearch = new dynamic_search("crockery");
        // Search for a spoon in crockery using dynamic_search
        dynamicSearch.search.setText("Spoon");
        dynamicSearch.submit.doClick();
        dynamicSearch.available_items.setSelectedIndex(0);
        dynamicSearch.addcart.doClick();
        // Add the found item to the cart
        try {
            manage_cart cart = new manage_cart();
            cart.proceed_order.doClick();
            // Verify that the spoon is no longer in the cart
            assertFalse(Arrays.asList(cart.CART).contains("spoon"));
        } catch (Exception e) {
        }
    }

}
