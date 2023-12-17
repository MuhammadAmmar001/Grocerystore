import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

class LoginFrame implements ActionListener {

    JFrame frame = new JFrame("LOGIN FORM");
    JLabel userLabel = new JLabel("USERNAME"), label;
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton createAccount = new JButton("CREATE ACCOUNT");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel pwdRes = new JLabel();

    LoginFrame() {
  
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setBackgroundImage();

        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setBackgroundImage() {
        ImageIcon image = new ImageIcon("mart.jpg");
        label = new JLabel(image);
        label.setBounds(0, 0, 1650, 1080);
        frame.add(label);
    }

    public void setLayoutManager() {
        frame.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setForeground(Color.white);
        userLabel.setFont(new Font("Arial", Font.BOLD, 20));
        userLabel.setBounds(600, 300, 200, 30);
        passwordLabel.setBounds(600, 350, 200, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passwordLabel.setForeground(Color.white);
        userTextField.setBounds(750, 300, 200, 30);
        passwordField.setBounds(750, 350, 200, 30);
        passwordField.setEchoChar('*');
        showPassword.setBounds(750, 400, 200, 30);
        showPassword.setFocusable(false);
        loginButton.setBounds(630, 500, 100, 30);
        loginButton.setFocusable(false);
        createAccount.setBounds(770, 500, 150, 30);

        pwdRes.setFont(new Font("Arial", Font.PLAIN, 20));
        pwdRes.setBounds(630, 600, 500, 25);

    }

    public void addComponentsToContainer() {
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(userTextField);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(createAccount);
        frame.add(pwdRes);

    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        createAccount.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccount) {
            Registration registration = new Registration();

        }
        if (e.getSource() == loginButton) {
            String status = "";
            String userText;
            String pwdText;
            userText = "{" + userTextField.getText() + "}";
            pwdText = "{" + String.valueOf(passwordField.getPassword()) + "}";
            File UserFile = new File(
                    "userfile.txt");
            try {
                FileReader userFileReader = new FileReader(UserFile);
                Scanner userFileScanner = new Scanner(UserFile);
                while (userFileScanner.hasNextLine()) {
                    String line = userFileScanner.nextLine();
                    if (line.contains(userText) && line.contains(pwdText) && !userText.equals("")
                            && !pwdText.equals("")) {
                        File cart = new File(
                                "cart.txt");
                        FileWriter fileWriter = new FileWriter(cart);
                        status = "SUCCESSFULLY LOGGED IN";
                        MENU menu = new MENU();
                        frame.dispose();

                        break;
                    }

                    else {
                        status = "WRONG PASSWORD";

                    }
                }
                pwdRes.setText(status);

                //
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        // Coding Part of RESET button
        if (e.getSource() == createAccount) {
            userTextField.setText("");
            passwordField.setText("");
        }
        // Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }

}

public class Main {
    public static void main(String[] a) {
        LoginFrame loginFrame = new LoginFrame();
    }

}