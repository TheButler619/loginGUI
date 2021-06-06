package za.ac.cput.loginGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {
    private JPanel panelCenter, panelSouth;
    private JButton btnCalender, btnTask, btnNotification, btnProgress, btnLogOut;

    public Home(){
        super("Home");
        panelCenter = new JPanel();
        //panelEast = new JPanel();
        //panelWest = new JPanel();
        panelSouth = new JPanel();
        btnCalender = new JButton("View Calender");
        btnNotification = new JButton("View Notifications");
        btnTask = new JButton("View Tasks");
        btnProgress = new JButton("View Progress");
        btnLogOut = new JButton("Log Out");
    }
    public void setGUI(){
        panelCenter.setLayout(new GridLayout(2,2,3,3));
        //panelEast.setLayout(new GridLayout(1,1,3,3));
        //panelWest.setLayout(new GridLayout(4,1,3,3));
        panelSouth.setLayout(new GridLayout(1,1));

        panelCenter.setBorder(BorderFactory.createEmptyBorder(100,90,100,90));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(0,250,25,250));

        //setting the GUI Background Color
        panelCenter.setBackground(new Color(255,205,108));
        panelSouth.setBackground(new Color(255,205,108));
        //panelWest.setBackground(new Color(255,205,108));
        //panelEast.setBackground(new Color(255,205,108));

        btnTask.setPreferredSize(new Dimension(60, 40));
        btnNotification.setPreferredSize(new Dimension(60, 40));
        btnProgress.setPreferredSize(new Dimension(60, 40));
        btnCalender.setPreferredSize(new Dimension(60, 40));

        //btnTask.setPreferredSize(new Dimension(100, 20));
        //btnNotification.setPreferredSize(new Dimension(100, 20));
        //btnProgress.setPreferredSize(new Dimension(100, 20));
        //btnCalender.setPreferredSize(new Dimension(100, 20));

        btnLogOut.setPreferredSize(new Dimension(90, 40));

        panelCenter.add(btnCalender);
        panelCenter.add(btnTask);
        panelCenter.add(btnNotification);
        panelCenter.add(btnProgress);

        //panelWest.add(btnCalender);
        //panelWest.add(btnTask);
        //panelWest.add(btnNotification);
        //panelWest.add(btnProgress);

        panelSouth.add(btnLogOut);

        btnCalender.addActionListener(this);
        btnProgress.addActionListener(this);
        btnNotification.addActionListener(this);
        btnTask.addActionListener(this);
        btnLogOut.addActionListener(this);

        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        //this.add(panelWest, BorderLayout.WEST);
        //this.add(panelEast, BorderLayout.EAST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        else if (e.getActionCommand().equals("Log Out")) {
            this.dispose();
            Login login = new Login();
            login.setLogin();
        }
    }

    public static void main(String[] args) {

        new Home().setGUI();
    }
}
