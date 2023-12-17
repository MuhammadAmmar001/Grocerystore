import org.junit.Test;

import java.util.Arrays;

import javax.swing.ListModel;
import javax.swing.SwingUtilities;

import org.junit.Assert;

public class dynamicSearchTest {
    @Test
    public void testEmptySearch() {
        SwingUtilities.invokeLater(() -> {

            // Initialize dynamic_search object and set search term to empty
            dynamic_search search = new dynamic_search("house");
            search.search.setText("");
            search.submit.doClick();

            // Assert "not found" message is visible
            Assert.assertTrue(search.notFound.isVisible());

            // Assert product list is not visible
            Assert.assertFalse(search.available_items.isVisible());
        });
    }

    @Test
    public void testValidSearchExistingProduct() {
        // Initialize dynamic_search object and set search term
        dynamic_search search = new dynamic_search("house");
        search.search.setText("broom");
        search.submit.doClick();

        // Assert product list contains searched item
        ListModel<String> listModel = search.available_items.getModel();
        int size = listModel.getSize();
        String[] listedItems = new String[size];

        for (int i = 0; i < size; i++) {
            listedItems[i] = listModel.getElementAt(i);
        }

        Assert.assertTrue(Arrays.stream(listedItems).anyMatch(item -> item.contains("broom")));
    }

    @Test
    public void testValidSearchNonexistentProduct() {
        // Initialize dynamic_search object and set search term
        dynamic_search search = new dynamic_search("house");
        search.search.setText("Unicorn");
        search.submit.doClick();

        // Assert "not found" message is visible
        Assert.assertTrue(search.notFound.isVisible());

        // Assert product list is not visible
        Assert.assertFalse(search.available_items.isVisible());
    }

}
