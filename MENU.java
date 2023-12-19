import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Represents a graphical user interface for a grocery store menu.
 * Provides buttons to access different sections of the store and
 * functionalities.
 * Implements ActionListener to handle button click events.
 */
public class MENU implements ActionListener {
    JFrame menu;
    JLabel Title;
    JButton crockery, food, poultry, house, history, cart;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) size.getWidth();
    int height = (int) size.getHeight();

    /**
     * Constructor initializing the grocery store menu window with buttons.
     * Sets up various buttons to access different sections of the store.
     * Handles button click events for navigation within the store.
     */
    MENU() {
        menu = new JFrame("MENU");
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setLayout(null);

        Title = new JLabel("MENU FOR OUR GROCERY STORE");
        Title.setForeground(Color.white);
        Title.setBounds(500, 80, 800, 40);
        Title.setFont(new Font("Arial", Font.PLAIN, 30));
        menu.add(Title);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);

        crockery = new JButton("CROCKERY ITEMS");
        crockery.setBounds(650, 150, 200, 50);
        menu.add(crockery);
        crockery.addActionListener(this::actionPerformed);

        food = new JButton("FOOD AND VEGITABLES");
        food.setBounds(650, 240, 200, 50);
        menu.add(food);
        food.addActionListener(this::actionPerformed);

        poultry = new JButton("POULTRY AND DAIRY");
        poultry.setBounds(650, 330, 200, 50);
        menu.add(poultry);
        poultry.addActionListener(this::actionPerformed);

        house = new JButton("HOUSE HOLD PRODUCTS");
        house.setBounds(650, 420, 200, 50);
        menu.add(house);
        house.addActionListener(this::actionPerformed);

        history = new JButton("MY SHOPPING HISTORY");
        history.setBounds(650, 510, 200, 50);
        menu.add(history);
        history.addActionListener(this::actionPerformed);

        cart = new JButton("CART");
        cart.setBounds(675, 600, 150, 50);
        menu.add(cart);
        cart.addActionListener(this::actionPerformed);

        setBackgroundImage();
        menu.setVisible(true);

    }

    /**
     * Main method to initialize the grocery store menu.
     *
     * @param args Command-line arguments (not used here).
     */
    public static void main(String[] args) {
        MENU menu1 = new MENU();
    }

    /**
     * Sets the background image for the grocery store menu window.
     * Loads and sets an image as the background for the menu window.
     */
    public void setBackgroundImage() {
        ImageIcon image = new ImageIcon("D:\\NUST\\Semester 2\\OOP\\Project\\src\\bg.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, width, height);
        menu.add(label);
    }

    /**
     * Handles button click events triggered by various store section buttons.
     * Creates instances of different classes (dynamic_search, manage_cart, history)
     * based on button clicks.
     * Disposes of the current menu window after triggering actions.
     *
     * @param e ActionEvent triggered by button clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crockery) {
            dynamic_search dynamic_search = new dynamic_search("crockery");
            menu.dispose();
        }
        if (e.getSource() == food) {
            dynamic_search dynamic_search = new dynamic_search("vegetables");
            menu.dispose();
        }
        if (e.getSource() == poultry) {
            dynamic_search dynamic_search = new dynamic_search("poultry");
            menu.dispose();
        }
        if (e.getSource() == house) {
            dynamic_search dynamic_search = new dynamic_search("house");
            menu.dispose();
        }
        if (e.getSource() == cart) {
            try {
                manage_cart manage_cart = new manage_cart();
                menu.dispose();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == history) {
            try {
                history history1 = new history();
                menu.dispose();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
