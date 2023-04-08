package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISACreateStaffAccount extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JButton createButton;
    private JButton backButton;

    public GUISACreateStaffAccount(JFrame parent) {

        super(parent);
        setTitle("Create Staff Account");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISACreateStaffAccount panel = new GUISACreateStaffAccount(null);
    }
}
