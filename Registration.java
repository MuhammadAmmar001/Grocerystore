import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

class Registration extends JFrame implements ActionListener {
    public JTextField nameTextField, mobileTextField;
    public JPasswordField passwordField;
    public JTextArea addressTextArea, resultTextArea;
    public JRadioButton maleRadioButton, femaleRadioButton;
    public JComboBox<String> dateComboBox, monthComboBox, yearComboBox;
    public JCheckBox termsCheckBox;
    public JButton submitButton, resetButton, BackToLogin;

    public Registration() {
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initializeUI();

    }

    private void initializeUI() {

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Form Elements
        nameTextField = new JTextField(20);
        mobileTextField = new JTextField(20);
        passwordField = new JPasswordField(20);
        addressTextArea = new JTextArea(5, 20);
        resultTextArea = new JTextArea(5, 20);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        dateComboBox = new JComboBox<>();
        monthComboBox = new JComboBox<>();
        yearComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dateComboBox.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(String.valueOf(i));
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        for (int i = year - 100; i <= year; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
        termsCheckBox = new JCheckBox("Accept Terms and Conditions");

        // Buttons
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        BackToLogin = new JButton("Back ");
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        BackToLogin.addActionListener(this);

        // Form Layout

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        formPanel.add(new JLabel("Name:"), constraints);
        constraints.gridx = 1;
        formPanel.add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        formPanel.add(new JLabel("Mobile:"), constraints);
        constraints.gridx = 1;
        formPanel.add(mobileTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        formPanel.add(new JLabel("Password:"), constraints);
        constraints.gridx = 1;
        formPanel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        formPanel.add(new JLabel("Address:"), constraints);
        constraints.gridx = 1;
        constraints.gridwidth = 3;
        formPanel.add(addressTextArea, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        formPanel.add(new JLabel("Date of Birth:"), constraints);
        constraints.gridx = 1;
        formPanel.add(dateComboBox, constraints);
        constraints.gridx = 2;
        formPanel.add(monthComboBox, constraints);
        constraints.gridx = 3;
        formPanel.add(yearComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        formPanel.add(new JLabel("Gender:"), constraints);
        constraints.gridx = 1;
        formPanel.add(maleRadioButton, constraints);
        constraints.gridx = 2;
        formPanel.add(femaleRadioButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 4;
        formPanel.add(termsCheckBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 4;
        formPanel.add(submitButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 4;
        formPanel.add(resetButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 4;
        formPanel.add(BackToLogin, constraints);

        container.add(formPanel, BorderLayout.CENTER);
        container.add(new JScrollPane(resultTextArea), BorderLayout.SOUTH);

        // Add the background image panel to the container
        container.add(new JScrollPane(resultTextArea), BorderLayout.SOUTH);

        // Set window properties
        setTitle("Registration Form");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            submit();

        } else if (e.getSource() == resetButton) {

            reset();
        } else if (e.getSource() == BackToLogin) {
            LoginFrame loginFrame = new LoginFrame();
        }

    }

    private void reset() {
        nameTextField.setText("");
        mobileTextField.setText("");
        passwordField.setText("");
        addressTextArea.setText("");
        dateComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        maleRadioButton.setSelected(true);
        termsCheckBox.setSelected(false);

        // Clear Result Area
        resultTextArea.setText("");
    }

    private void submit() {
        // Clear Result Area
        resultTextArea.setText("");

        // Retrieve Data
        String name = nameTextField.getText();

        String mobile = mobileTextField.getText();
        if (!isValidMobileNumber(mobile)) {
            resultTextArea.append("Please enter a valid 11-digit mobile number.");
            return;
        }

        String password = new String(passwordField.getPassword());
        if (!isValidPassword(password)) {
            resultTextArea.append(
                    "Please enter a strong password (at least 8 characters with uppercase, lowercase, and a special character).");
            return;
        }

        String address = addressTextArea.getText();
        String date = (String) dateComboBox.getSelectedItem();
        String month = (String) monthComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        String dob = date + "/" + month + "/" + year;
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        boolean termsAccepted = termsCheckBox.isSelected();

        // Validate Data

        if (name.isEmpty()) {
            resultTextArea.append("Please enter your name.");
            return;
        }

        else if (mobile.isEmpty()) {
            resultTextArea.append("Please enter your mobile number.");
            return;
        }

        else if (!isValidMobileNumber(mobile)) {
            resultTextArea.append("Please enter a valid 11-digit mobile number.");
            return;
        }

        else if (!isValidPassword(password)) {
            resultTextArea.append(
                    "Please enter a strong password (at least 8 characters with uppercase, lowercase, and a special character).");
            return;
        }

        else if (address.isEmpty()) {
            resultTextArea.append("Please enter your address.");
            return;
        }

        else if (date.isEmpty() || month.isEmpty() || year.isEmpty()) {
            resultTextArea.append("Please enter your complete date of birth.");
            return;
        }

        else if (!termsAccepted) {
            resultTextArea.append("Please accept the terms and conditions.");
            return;
        }

        // Display Data
        resultTextArea.append("Name: " + name + "\n");
        resultTextArea.append("Mobile: " + mobile + "\n");
        resultTextArea.append("Address: " + address + "\n");
        resultTextArea.append("Date of Birth: " + dob + "\n");
        resultTextArea.append("Gender: " + gender + "\n");
        resultTextArea.append("Terms and Conditions: " + (termsAccepted ? "Accepted" : "Not Accepted") + "\n");
        processRegistration();
    }

    private boolean isValidMobileNumber(String mobile) {
        return mobile.matches("\\d{11}");
    }

    private boolean isValidPassword(String password) {

        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    private void processRegistration() {
        if (termsCheckBox.isSelected()) {
            String data1;
            String data = "Name : "
                    + "{" + nameTextField.getText() + "}" + " "
                    + "Mobile : "
                    + mobileTextField.getText() + " ";
            if (maleRadioButton.isSelected())
                data1 = "Gender : Male"
                        + " ";
            else
                data1 = "Gender : Female"
                        + " ";
            String data2 = "DOB : "
                    + (String) dateComboBox.getSelectedItem()
                    + "/" + (String) monthComboBox.getSelectedItem()
                    + "/" + (String) yearComboBox.getSelectedItem()
                    + " ";

            String data3 = "Address : " + addressTextArea.getText();
            String data4 = "Password : " + "{" + new String(passwordField.getPassword()) + "}" + " ";

            resultTextArea.setText(data + "\n" + data4 + "\n" + data1 + "\n" + data2 + "\n" + data3);
            resultTextArea.setEditable(false);
            // Assuming that 'res' is a label for displaying the result
            resultTextArea.setText("Registration Successfully..");

            // Adjust the file path based on your project structure
            File userFile = new File("userfile.txt");
            try {
                FileWriter userFileWriter = new FileWriter(userFile, true);
                userFileWriter.write("\n");
                userFileWriter.write(data + data4 + data1 + data2 + data3);
                System.out.println(resultTextArea.getText());
                userFileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
