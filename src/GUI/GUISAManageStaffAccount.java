package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAManageStaffAccount extends JDialog {
    private JPanel panel1;
    private JButton editStaffAccountButton;
    private JButton createStaffAccountButton;
    private JButton archiveStaffAccountButton;
    private JButton backButton;
    private JButton logOUtButton;

    public GUISAManageStaffAccount(JFrame parent) {

        super(parent);
        setTitle("Manage Staff Account");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 350));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAManageStaffAccount panel = new GUISAManageStaffAccount(null);
    }
}
