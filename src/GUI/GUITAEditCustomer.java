package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITAEditCustomer extends JDialog{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JRadioButton regularRadioButton;
    private JRadioButton valuedRadioButton;
    private JButton backButton;
    private JButton logoutButton;

    public GUITAEditCustomer(JFrame parent) {

        super(parent);
        setTitle("Edit Customer");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITAEditCustomer login = new GUITAEditCustomer(null);
    }
}

