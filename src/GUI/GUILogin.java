package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin extends JDialog {
    private JPanel mainPanel;
    private JPasswordField tfPassword;
    private JTextField tfEmail;
    private JTextField tfuserName;
    private JButton btnLogin;
    private JComboBox comboBox1;
    private JPasswordField tfpassWord;


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
        setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.equals("System Administrator")){
                    // Direct user to System Admin screen

                }


            }
        });
    }


    public static void main(String[] args) {
        GUILogin login = new GUILogin(null);
    }
}