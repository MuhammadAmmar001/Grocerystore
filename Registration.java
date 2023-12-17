// Java program to implement
// a Simple Registration Form
// using J

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class MyFrame
        extends JFrame
        implements ActionListener {

    // Components of the Form
    public Container c;
    public JLabel title;
    public JLabel name;
    public JTextField tname;
    public JTextField tpassword;
    public JLabel password;
    public JLabel mno;
    public JTextField tmno;
    public JLabel gender;
    public JRadioButton male;
    public JRadioButton female;
    public ButtonGroup gengp;
    public JLabel dob;
    public JComboBox date;
    public JComboBox month;
    public JComboBox year;
    public JLabel add;
    public JTextArea tadd;
    public JCheckBox term;
    public JButton sub;
    public JButton reset;
    JTextArea tout;
    public JLabel res;
    public JTextArea resadd;
    public File userFile;

    public File getUserFile() {
        return userFile;
    }

    public void setUserFile(File userFile) {
        this.userFile = userFile;
    }

    private String dates[] = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[] = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[] = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };

    // constructor, to initialize the components
    // with default values.
    public MyFrame() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(310, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setForeground(Color.white);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 25);
        tname.setLocation(200, 100);
        c.add(tname);

        password = new JLabel("Password");
        password.setForeground(Color.white);
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 150);
        c.add(password);

        tpassword = new JTextField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(200, 25);
        tpassword.setLocation(200, 150);
        c.add(tpassword);

        mno = new JLabel("Mobile");
        mno.setForeground(Color.white);
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 200);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(200, 25);
        tmno.setLocation(200, 200);
        c.add(tmno);

        gender = new JLabel("Gender");
        gender.setForeground(Color.white);
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 250);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.black);
        male.setForeground(Color.white);
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 250);
        c.add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.black);
        female.setForeground(Color.white);
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 250);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setForeground(Color.white);
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 300);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 300);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 300);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 300);
        c.add(year);

        add = new JLabel("Address");
        add.setForeground(Color.white);
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 350);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 350);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions");
        term.setBackground(Color.black);
        term.setForeground(Color.white);
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(140, 450);
        term.setFocusable(false);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.BOLD, 15));
        sub.setSize(100, 25);
        sub.setLocation(150, 500);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        reset.setSize(100, 25);
        reset.setLocation(270, 500);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setForeground(Color.white);
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 550);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);
        c.setBackground(Color.black);
        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data1;
                if (tname.getText().equals("")) {
                    res.setText("Please enter your name");
                    return;
                } else if (tpassword.getText().equals("")) {
                    res.setText("Password cannot be empty");
                    return;
                } else if (tmno.getText().matches(".*[a-zA-Z].*")) {
                    res.setText("Please enter a valid mobile number");
                    return;
                }

                String data = "Name : "
                        + "{" + tname.getText() + "}" + " "
                        + "Mobile : "
                        + tmno.getText() + " ";
                if (male.isSelected())
                    data1 = "Gender : Male"
                            + " ";
                else
                    data1 = "Gender : Female"
                            + " ";
                String data2 = "DOB : "
                        + (String) date.getSelectedItem()
                        + "/" + (String) month.getSelectedItem()
                        + "/" + (String) year.getSelectedItem()
                        + " ";

                String data3 = "Address : " + tadd.getText();
                String data4 = "password :" + "{" + tpassword.getText() + "}" + " ";
                tout.setText(data + "\n" + data4 + "\n" + data1 + "\n" + data2 + "\n" + data3);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
                File UserFile = new File("D:\\NUST\\Semester 2\\OOP\\Project\\src\\userfile.txt");
                try {
                    FileWriter userfileWriter = new FileWriter(
                            "D:\\NUST\\Semester 2\\OOP\\Project\\src\\userfile.txt",
                            true);
                    userfileWriter.write("\n");
                    userfileWriter.write(data + data4 + data1 + data2 + data3);
                    System.out.println(tout.getText());
                    System.out.println(tout.getText());
                    userfileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                setUserFile(UserFile);
            } else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resadd.setText(def);
        }

    }

}
