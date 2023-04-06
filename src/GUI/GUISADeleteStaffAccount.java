package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISADeleteStaffAccount extends JDialog {
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JButton deleteStaffAccountButton;
    private JButton archivedButton;
    private JButton logoutButton;
    private JButton backButton;

    public GUISADeleteStaffAccount(JFrame parent) {

        super(parent);
        setTitle("Delete Staff Account");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISADeleteStaffAccount panel = new GUISADeleteStaffAccount(null);
    }
}
