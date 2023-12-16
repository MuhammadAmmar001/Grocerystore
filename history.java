
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class history implements ActionListener {
    JFrame hist;
    JTextArea RECORD;
    JButton back;
    String rec = "";

    history() throws FileNotFoundException {
        hist = new JFrame("SHOPING HISTORY");
        hist.setExtendedState(JFrame.MAXIMIZED_BOTH);
        hist.setDefaultCloseOperation(EXIT_ON_CLOSE);
        hist.setBackground(Color.black);
        hist.setLayout(null);

        File REC = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\record.txt");
        Scanner read = new Scanner(REC);
        while (read.hasNextLine()) {
            String l = read.nextLine();
            System.out.println(l);
            rec = rec + l + "\n";
        }
        RECORD = new JTextArea(rec);
        RECORD.setFont(new Font("Arial", Font.PLAIN, 15));
        RECORD.setSize(1365, 1060);
        RECORD.setLocation(0, 50);
        RECORD.setLineWrap(true);
        RECORD.setEditable(false);
        hist.add(RECORD);
        hist.setVisible(true);

        back = new JButton("←");
        back.setBounds(20, 20, 70, 30);
        back.setFont((new Font("Serif", Font.PLAIN, 40)));
        hist.add(back);
        back.addActionListener(this::actionPerformed);
        hist.setVisible(true);

    }

    public static void main(String[] args) throws FileNotFoundException {
        history j = new history();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            MENU menu = new MENU();
            hist.dispose();
        }
    }
}
