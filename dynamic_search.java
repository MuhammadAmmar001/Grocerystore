import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class dynamic_search implements ActionListener {
    int k;
    String type;
    JFrame dynWindow;
    JTextField search;
    JList available_items;
    JButton submit, addcart, viewCart, back;
    JLabel searchItem, Title, notFound, label;
    String[] searchedProd;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    int width = (int) size.getWidth();

    int height = (int) size.getHeight();

    dynamic_search(String type) {
        setType(type);

        k = 0;

        dynWindow = new JFrame("SEARCH WINDOW");
        dynWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dynWindow.setLayout(null);
        dynWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Title = new JLabel("Search an item to order");
        Title.setForeground(Color.white);
        Title.setFont((new Font("Serif", Font.PLAIN, 30)));
        Title.setBounds(650, 150, 400, 50);
        dynWindow.add(Title);

        search = new JTextField();
        search.setBounds(650, 200, 300, 60);
        dynWindow.add(search);

        searchItem = new JLabel("ENTER PRODUCT NAME");
        searchItem.setForeground(Color.white);
        searchItem.setBounds(500, 200, 300, 50);
        dynWindow.add(searchItem);

        submit = new JButton("SUBMIT");
        submit.setBounds(970, 210, 100, 40);
        submit.addActionListener(this::actionPerformed);
        dynWindow.add(submit);

        notFound = new JLabel("SORRY PRODUCT NOT FOUND");
        notFound.setForeground(Color.red);
        notFound.setBounds(600, 350, 600, 60);
        notFound.setFont((new Font("Serif", Font.PLAIN, 30)));
        dynWindow.add(notFound);
        notFound.setVisible(false);

        addcart = new JButton("ADD TO CART");
        addcart.setBounds(700, 550, 200, 40);
        addcart.addActionListener(this::actionPerformed);
        dynWindow.add(addcart);
        addcart.setVisible(false);

        viewCart = new JButton("VIEW CART");
        viewCart.setBounds(900, 550, 100, 40);
        viewCart.addActionListener(this::actionPerformed);
        dynWindow.add(viewCart);
        viewCart.setVisible(false);

        back = new JButton("←");
        back.setBounds(20, 20, 70, 30);
        back.setFont((new Font("Serif", Font.PLAIN, 40)));
        dynWindow.add(back);
        back.addActionListener(this::actionPerformed);

        ImageIcon image = new ImageIcon("D:\\NUST\\Semester 2\\OOP\\Project\\src\\bg.png");
        label = new JLabel(image);
        label.setBounds(0, 0, width, height);
        dynWindow.add(label);
        dynWindow.setVisible(true);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // public static void main(String[] args) {
    // dynamic_search dynamic_search=new dynamic_search();
    // }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            dynWindow.remove(label);

            searchedProd = new String[200];
            if (k > 0) {
                dynWindow.remove(available_items);
            }
            k += 1;

            int n = 0;
            File store = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\store.txt");
            try {
                Scanner read = new Scanner(store);
                while (read.hasNextLine()) {
                    String rec = read.nextLine();
                    String[] itemsA = rec.split(":");
                    if (itemsA[0] == "class") {
                        continue;
                    }
                    if (itemsA[1].contains(search.getText()) && Objects.equals(itemsA[0], getType())) {
                        System.out.println("true");
                        searchedProd[n] = itemsA[1] + "  price:" + itemsA[3];
                        n += 1;
                    }
                }
                available_items = new JList<>(searchedProd);
                if (searchedProd[0] != null) {
                    notFound.setVisible(false);
                    addcart.setVisible(true);
                    System.out.println(Arrays.toString(searchedProd));

                    available_items.setBounds(500, 300, 600, 200);
                    dynWindow.add(available_items);
                    available_items.setVisible(true);
                    dynWindow.add(label);
                    dynWindow.invalidate();
                    dynWindow.validate();
                    dynWindow.repaint();
                } else {
                    dynWindow.add(label);
                    notFound.setVisible(true);
                    available_items.setVisible(false);
                    addcart.setVisible(false);
                    dynWindow.invalidate();
                    dynWindow.validate();
                    dynWindow.repaint();
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == addcart) {
            viewCart.setVisible(true);
            File cartItems = new File(
                    "D:\\NUST\\Semester 2\\OOP\\Project\\src\\cart.txt");
            try {
                FileWriter fileWriter = new FileWriter(cartItems, true);
                if (available_items.getSelectedValue() != null) {
                    fileWriter.write(available_items.getSelectedValue() + "\n");
                }
                fileWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == viewCart) {
            try {
                manage_cart manage_cart = new manage_cart();
                dynWindow.dispose();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == back) {
            MENU menu = new MENU();
            dynWindow.dispose();
        }

    }

    public static void main(String[] args) {
        dynamic_search dynamic_search = new dynamic_search("house");
    }
}
