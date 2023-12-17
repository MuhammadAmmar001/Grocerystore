import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class manage_cart_Test {
    @Test
    public void testItemRemovalOnOrderCompletion() {
        // Setup
        try {

            manage_cart cart = new manage_cart();
            String testItem = "Pizza: 1: 100";
            cart.CART[0] = testItem; // Add test item to cart

            // Simulate completing an order
            cart.proceed_order.doClick();

            // Assert that the test item is removed from the cart
            assertFalse(Arrays.asList(cart.CART).contains(testItem));
        } catch (Exception e) {
        }
    }

    @Test
    public void testTotalBillCalculation() {
        // Setup
        try {
            manage_cart cart = new manage_cart();
            String item1 = "Pizza: 1: 100";
            String item2 = "Shirt: 1: 200";
            cart.CART[0] = item1;
            cart.CART[1] = item2;

            // Simulate completing an order
            cart.proceed_order.doClick();

            // Extract and parse total bill from displayed label
            int actualBill = Integer.parseInt(cart.Totalbill.getText().split("Rs.")[1]);

            // Assert that the bill is accurately calculated
            int expectedBill = Integer.parseInt(item1.split(":")[1]) + Integer.parseInt(item2.split(":")[1]);
            assertEquals(expectedBill, actualBill);

        } catch (Exception e) {
        }
    }

}
