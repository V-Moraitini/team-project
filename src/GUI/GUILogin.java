package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Backend.persistenceLayer.User;
import Backend.persistenceLayer.UserType;
import Backend.serviceLayer.*;
public class GUILogin extends JDialog {
    private JPanel mainPanel;
    private JPasswordField tfPassword;
    private JTextField tfEmail;
    private JTextField tfuserName;
    private JButton btnLogin;
    private JComboBox comboBox1;
    private JPasswordField tfpassWord;
    private UserSL userSL;



    public GUILogin(JFrame parent) {
        super(parent);
        setTitle("Login");
        comboBox1.addItem("");
        comboBox1.addItem("System Administrator");
        comboBox1.addItem("Office Manager");
        comboBox1.addItem("Travel Advisor");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(450, 374));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                userSL = new UserSL();



                if (comboBox1.getSelectedItem().equals("System Administrator")) {
                    // Direct user to System Admin screen
                    User user = userSL.login(tfEmail.getText(), tfPassword.getText(),UserType.SystemAdmin);
                    if ( user != null) {
                        dispose();
                        new GUISystemAdmin(null).setVisible(false);
                        mainPanel.setVisible(false);
                    }
                    else {  JOptionPane.showMessageDialog(GUILogin.this, "Invalid Credentials");

                    }
                } else if (comboBox1.getSelectedItem().equals("Office Manager")){
                    //Direct user to Office Manager page
                    User user = userSL.login(tfEmail.getText(), tfPassword.getText(),UserType.OfficeManager);
                    if ( user != null) {
                        dispose();
                        new GUIOfficeManager(null).setVisible(false);
                        mainPanel.setVisible(false);
                    }
                    else {  JOptionPane.showMessageDialog(GUILogin.this, "Invalid Credentials");

                    }
                } else if (comboBox1.getSelectedItem().equals("Travel Advisor")){
                    //Direct user to Travel Advisor page
                    User user = userSL.login(tfEmail.getText(), tfPassword.getText(),UserType.TravelAdvisor);
                    if ( user != null) {
                        dispose();
                        new GUITravelAdvisor(null).setVisible(false);
                        mainPanel.setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(GUILogin.this, "Invalid Credentials");

                    }
                } else {  JOptionPane.showMessageDialog(GUILogin.this, "Invalid Credentials");

                }
            }
        });

        setVisible(true);



    }


   /* public static void main(String[] args) {
        GUILogin login = new GUILogin(null);
    }

    */
}