package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITAUpdateCustomerAccount extends JDialog{
    private JPanel panel1;
    private JTextField textField1;
    private JButton searchButton;
    private JButton button1;
    private JButton logoutButton;
    private JList list1;
    private JList list2;
    private JList list3;

    public GUITAUpdateCustomerAccount(JFrame parent) {

        super(parent);
        setTitle("Update Customer Account");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITAUpdateCustomerAccount login = new GUITAUpdateCustomerAccount(null);
    }
}

