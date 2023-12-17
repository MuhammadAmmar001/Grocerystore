import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class manage_cart implements ActionListener {
    JFrame managecart;
    String[] CART, final_cart;
    JList cartItems;
    JButton remove, proceed_order, back;
    JLabel Totalbill, cartitems, saveREC, label;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    int width = (int) size.getWidth();

    int height = (int) size.getHeight();

    int bill = 0;

    manage_cart() throws FileNotFoundException {

        managecart = new JFrame();
        managecart.setExtendedState(JFrame.MAXIMIZED_BOTH);
        managecart.setDefaultCloseOperation(EXIT_ON_CLOSE);
        managecart.setLayout(null);

        CART = new String[200];
        File cart = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\cart.txt");
        Scanner reader = new Scanner(cart);
        int n = 0;
        while (reader.hasNextLine()) {
            String item = reader.nextLine();
            CART[n] = item;
            n += 1;
        }
        cartItems = new JList<>(CART);
        cartItems.setBounds(500, 300, 500, 200);
        managecart.add(cartItems);
        managecart.invalidate();
        managecart.validate();
        managecart.repaint();
        cartItems.setVisible(true);

        cartitems = new JLabel("CART  ITEMS");
        cartitems.setForeground(Color.white);
        cartitems.setBounds(400, 300, 100, 50);
        managecart.add(cartitems);

        remove = new JButton("REMOVE FROM CART");
        remove.setBounds(530, 550, 200, 50);
        managecart.add(remove);
        remove.addActionListener(this::actionPerformed);

        proceed_order = new JButton("PROCEED ORDER");
        proceed_order.setBounds(770, 550, 200, 50);
        managecart.add(proceed_order);
        proceed_order.addActionListener(this::actionPerformed);

        Totalbill = new JLabel("lllll");
        Totalbill.setBounds(1100, 290, 600, 50);
        Totalbill.setFont(new Font("Arial", Font.BOLD, 20));
        managecart.add(Totalbill);
        Totalbill.setVisible(false);

        saveREC = new JLabel("YOUR ORDER HAS BEEN FINALED AND RECORD HAS BEEN SAVED");
        saveREC.setForeground(Color.white);
        saveREC.setBounds(420, 700, 900, 50);
        saveREC.setFont(new Font("Arial", Font.BOLD, 20));
        managecart.add(saveREC);
        saveREC.setVisible(false);

        back = new JButton("←");
        back.setBounds(20, 20, 70, 30);
        back.setFont((new Font("Serif", Font.PLAIN, 40)));
        managecart.add(back);
        back.addActionListener(this::actionPerformed);
        setBackgroundImage();
        managecart.setVisible(true);

    }

    public static void main(String[] args) throws FileNotFoundException {
        manage_cart manage_cart = new manage_cart();
    }

    public void setBackgroundImage() {
        ImageIcon image = new ImageIcon("D:\\NUST\\Semester 2\\OOP\\Project\\src\\bg.png");
        label = new JLabel(image);
        label.setBounds(0, 0, width, height);
        managecart.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove) {
            managecart.remove(label);
            bill = 0;
            Totalbill.setVisible(false);
            final_cart = new String[200];
            managecart.remove(cartItems);
            managecart.invalidate();
            managecart.validate();
            managecart.repaint();
            int i = 0;
            for (String s : CART) {
                if (s == cartItems.getSelectedValue()) {
                    continue;
                }
                CART[i] = s;
                i += 1;
            }

            cartItems = new JList<>(CART);
            cartItems.setBounds(500, 300, 500, 200);
            managecart.add(cartItems);
            managecart.add(label);
            managecart.invalidate();
            managecart.validate();
            managecart.repaint();
            cartItems.setVisible(true);
            File cart = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\cart.txt");
            try {
                FileWriter cartwrite = new FileWriter(cart);
                for (String s : CART) {
                    if (s == null) {
                        continue;
                    }
                    cartwrite.write(s + "\n");
                }
                cartwrite.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        String[] NEWStore = new String[800];

        if (e.getSource() == proceed_order) {
            remove.setVisible(false);
            proceed_order.setVisible(false);
            saveREC.setVisible(true);

            for (String l : CART) {
                if (l == null) {
                    continue;
                }
                int b = Integer.parseInt(l.split(":")[1]);
                bill += b;
            }
            Totalbill.setText("Rs." + String.valueOf(bill) + " is your total bill");
            Totalbill.setForeground(Color.white);
            Totalbill.setVisible(true);

            File store = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\store.txt");
            try {
                Scanner readstore = new Scanner(store);
                int k = 0;
                while (readstore.hasNextLine()) {
                    String line = readstore.nextLine();
                    if (!Objects.equals(line, "") && !Objects.equals(line, "class:item:quantity:price")
                            && line != null) {
                        String[] STORE = line.split(":");
                        int newQuan = Integer.parseInt(STORE[2]);
                        for (String S : CART) {
                            if (S != null) {
                                String check = S.split("  ")[0];
                                if (line.contains(check)) {
                                    System.out.println(S);
                                    newQuan = newQuan - 1;
                                    System.out.println(STORE[2]);
                                    line = STORE[0] + ":" + STORE[1] + ":" + newQuan + ":" + STORE[3];
                                }
                            }

                        }
                        NEWStore[k] = line;
                        k += 1;
                    }
                }
                FileWriter storeWRITE = new FileWriter(store);
                storeWRITE.write("class:item:quantity:price" + "\n");
                for (String l : NEWStore) {
                    if (l == null) {
                        continue;
                    }
                    String[] s = l.split(":");
                    if (Integer.parseInt(s[2]) <= 0) {
                        continue;
                    }
                    storeWRITE.write(l + "\n");
                }
                storeWRITE.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            File rec = new File("record.txt");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            try {
                FileWriter recWriter = new FileWriter(rec, true);
                for (String L : CART) {
                    if (L == null) {
                        continue;
                    }
                    recWriter.write("[" + L + "]");
                }
                recWriter.write("  DATE:  " + dtf.format(now) + "\n");
                recWriter.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == back) {
            MENU menu = new MENU();
            managecart.dispose();
        }

    }
}