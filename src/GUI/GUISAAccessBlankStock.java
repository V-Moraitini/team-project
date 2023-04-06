package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAAccessBlankStock extends JDialog{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton saveButton;
    private JButton searchButton;
    private JButton logoutButton;
    private JButton backButton;

    public GUISAAccessBlankStock(JFrame parent) {

        super(parent);
        setTitle("Access Blank Stock");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAAccessBlankStock panel = new GUISAAccessBlankStock(null);
    }
}
