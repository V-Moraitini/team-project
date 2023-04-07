package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAAddNewBlank extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton backButton;
    private JButton confirmButton;

    public GUISAAddNewBlank(JFrame parent) {

        super(parent);
        setTitle("Add New Blank");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAAddNewBlank panel = new GUISAAddNewBlank(null);
    }
}
