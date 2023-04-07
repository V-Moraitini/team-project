package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAAccessDatabase extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JButton restoreDatabaseButton;
    private JButton backupDatabaseButton;
    private JButton backButton;

    public GUISAAccessDatabase(JFrame parent) {

        super(parent);
        setTitle("Access Database");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAAccessDatabase panel = new GUISAAccessDatabase(null);
    }
}
