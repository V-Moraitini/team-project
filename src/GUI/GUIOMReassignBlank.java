package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIOMReassignBlank extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton saveButton;
    private JButton backButton;

    public GUIOMReassignBlank(JFrame parent) {

        super(parent);
        setTitle("Reassign Blank");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 300));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOMReassignBlank panel = new GUIOMReassignBlank(null);
    }
}
