package za.ac.cput.loginGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {
    private JPanel panelNorth, panelEast, panelWest;
    private JLabel lblHome;
    private JButton btnCalender, btnTask, btnNotification, btnProgress;

    private Home(){
        panelNorth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        lblHome = new JLabel("Welcome", SwingConstants.CENTER);
        btnCalender = new JButton("View Calender");
        btnNotification = new JButton("View Notifications");
        btnTask = new JButton("View Tasks");
        btnProgress = new JButton("View Progress");
    }
    private void setGUI(){
        panelNorth.setLayout(new GridLayout(1,1));
        panelEast.setLayout(new GridLayout(2,1));
        panelWest.setLayout(new GridLayout(2,1));

        panelNorth.add(lblHome);

        panelWest.add(btnCalender);
        panelWest.add(btnTask);

        panelEast.add(btnNotification);
        panelEast.add(btnProgress);

        btnCalender.addActionListener(this);
        btnProgress.addActionListener(this);
        btnNotification.addActionListener(this);
        btnTask.addActionListener(this);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelEast, BorderLayout.EAST);
        this.add(panelWest, BorderLayout.WEST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("View Calender")) {
            JOptionPane.showMessageDialog(null, "Opening calender");
        }
        else if (e.getActionCommand().equals("View Notifications")) {
            JOptionPane.showMessageDialog(null, "Viewing notifications");
        }
        else if (e.getActionCommand().equals("View Tasks")) {
            JOptionPane.showMessageDialog(null, "Displaying tasks");
        }
        else if (e.getActionCommand().equals("View Progress")) {
            JOptionPane.showMessageDialog(null, "Showing progress");
        }
    }

    public static void main(String[] args) {

        new Home().setGUI();
    }
}
