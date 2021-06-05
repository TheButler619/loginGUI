package za.ac.cput.loginGUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    private JPanel panelNorth, panelCenter, panelSouth;
    private JLabel lblUsername, lblPassword, lblImage;
    private JTextField userName;
    private JPasswordField password;
    private JButton btnSubmit, btnSignUp;
    private ImageIcon image;
    private JLabel lblErrorOne, lblErrorTwo, lblBlank, lblBlankTwo, lblBlankThree, lblBlankFour, lblBlankFive;
    private JCheckBox checkBox;

    public Login(){
        super("Login");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        lblImage = new JLabel("" ,SwingConstants.CENTER);
        lblUsername = new JLabel("Username: ", SwingConstants.RIGHT);
        lblPassword = new JLabel("Password: ", SwingConstants.RIGHT);
        userName = new JTextField();
        password = new JPasswordField();
        btnSubmit = new JButton("Submit");
        btnSignUp = new JButton("Don't have an account? Register here.");
        image = new ImageIcon("LogIn.png");
        lblErrorOne = new JLabel("*Username Required");
        lblErrorTwo = new JLabel("*Password Required");
        lblBlank = new JLabel("");
        lblBlankTwo = new JLabel("");
        lblBlankThree = new JLabel("");
        lblBlankFour = new JLabel("");
        lblBlankFive = new JLabel("");
        checkBox = new JCheckBox("Show Password");
    }
    public void setLogin(){
        panelNorth.setLayout(new GridLayout(1,1));
        panelCenter.setLayout(new GridLayout(4,3, 3, 2));
        panelSouth.setLayout(new GridLayout(1,1));

        panelNorth.setBorder(BorderFactory.createEmptyBorder(25,25,5,25));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));

        //make error messages red
        lblErrorOne.setForeground(Color.RED);
        lblErrorTwo.setForeground(Color.RED);

        //adding image to GUI
        lblImage.setIcon(image);

        //hides password
        password.setEchoChar('*');

        //remove border around button
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setBorder(null);
        btnSignUp.setBorderPainted(false);

        //remove border of show button
        checkBox.setContentAreaFilled(false);

        //setting the GUI Background Color
        panelNorth.setBackground(new Color(255,205,108));
        panelCenter.setBackground(new Color(255,205,108));
        panelSouth.setBackground(new Color(255,205,108));

        //Error Handling set to invisible
        lblErrorOne.setVisible(false);
        lblErrorTwo.setVisible(false);

        //Setting size of textField, changing size of GUI too
        userName.setPreferredSize(new Dimension(200, 20));
        password.setPreferredSize(new Dimension(200, 20));

        //Adding necessary components to GUI
        panelNorth.add(lblImage);

        panelCenter.add(lblUsername);
        panelCenter.add(userName);
        panelCenter.add(lblErrorOne);
        panelCenter.add(lblPassword);
        panelCenter.add(password);
        panelCenter.add(lblErrorTwo);
        panelCenter.add(lblBlank);
        panelCenter.add(btnSubmit);
        panelCenter.add(lblBlankTwo);
        panelCenter.add(lblBlankThree);
        panelCenter.add(checkBox);

        panelSouth.add(lblBlankFour);
        panelSouth.add(btnSignUp);
        panelSouth.add(lblBlankFive);

        //Implementing the action listener, so that the buttons are responsive
        btnSubmit.addActionListener(this);
        btnSignUp.addActionListener(this);
        checkBox.addActionListener(this);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(checkBox.isSelected()){
            password.setEchoChar((char)0);
        }
        else{
            password.setEchoChar('*');
        }

        if (e.getActionCommand().equals("Submit")) {

            //if statement to project error's in case of empty fields
            //char value to return passwordField
            char[] input = password.getPassword();

            if(userName.getText().isEmpty() || input.length == 0){
                if(userName.getText().isEmpty()){
                    lblErrorOne.setVisible(true);
                }else{
                    lblErrorOne.setVisible(false);
                }
                if(input.length == 0){
                    lblErrorTwo.setVisible(true);
                }
                else{
                    lblErrorTwo.setVisible(false);
                }
                return;
            }

            else{
                JOptionPane.showMessageDialog(null, "Logging in");
                userName.setText("");
                password.setText("");
                lblErrorOne.setVisible(false);
                lblErrorTwo.setVisible(false);
                this.dispose();
            }

        } else if (e.getActionCommand().equals("Don't have an account? Register here.")) {
            this.dispose();
            SignUp signup = new SignUp();
            signup.setSignUp();

        }
    }
    public static void main(String[] args) {

        new Login().setLogin();
    }
}
