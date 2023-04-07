package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISystemAdmin extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JButton accessBlankStockButton;
    private JButton manageStaffAccountButton;
    private JButton accessDatabaseButton;
    private JButton accessCommissionButton;
    private JButton createCommissionButton;
    private JButton backButton;

    public GUISystemAdmin(JFrame parent) {

        super(parent);
        setTitle("System Administrator");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISystemAdmin panel = new GUISystemAdmin(null);
    }
}
