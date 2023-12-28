import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Represents a window displaying shopping history records.
 * Provides a view of past shopping records in a JTextArea.
 */
public class history implements ActionListener {
    JFrame hist;
    JTextArea RECORD;
    JButton back;
    String rec = "";

    /**
     * Constructor for the shopping history window.
     *
     * @throws FileNotFoundException if the record file is not found.
     */
    history() throws FileNotFoundException {
        hist = new JFrame("SHOPPING HISTORY");
        hist.setExtendedState(JFrame.MAXIMIZED_BOTH);
        hist.setDefaultCloseOperation(EXIT_ON_CLOSE);
        hist.setBackground(Color.black);
        hist.setLayout(null);

        // Read records from file and populate JTextArea
        File REC = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\record.txt");
        Scanner read = new Scanner(REC);
        while (read.hasNextLine()) {
            String l = read.nextLine();
            System.out.println(l);
            rec = rec + l + "\n";
        }

        // Set up JTextArea to display shopping records
        RECORD = new JTextArea(rec);
        RECORD.setFont(new Font("Arial", Font.PLAIN, 15));
        RECORD.setSize(1365, 1060);
        RECORD.setLocation(0, 50);
        RECORD.setLineWrap(true);
        RECORD.setEditable(false);
        hist.add(RECORD);
        hist.setVisible(true);

        // Create and configure back button
        back = new JButton("←");
        back.setBounds(20, 20, 70, 30);
        back.setFont((new Font("Serif", Font.PLAIN, 40)));
        hist.add(back);
        back.addActionListener(this::actionPerformed);
        hist.setVisible(true);
    }

    /**
     * The main entry point for the shopping history window.
     *
     * @param args The command line arguments (not used here).
     * @throws FileNotFoundException if the record file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        history j = new history();
    }

    /**
     * Handles the back button action to return to the MENU.
     *
     * @param e The ActionEvent triggered by the button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            MENU menu = new MENU();
            hist.dispose();
        }
    }
}
