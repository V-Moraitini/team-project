package GUI;
import java.awt.*;
import javax.swing.*;

public class GUISAAccessDatabaseSysAd extends JDialog{
    private JPanel panel1;
    private JButton backupDatabaseButton;
    private JButton restoreDatabaseButton;
    private JButton backButton;
    private JButton logoutButton;


    public GUISAAccessDatabaseSysAd(JFrame parent) {

        super(parent);
        setTitle("SystemAdmin");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAAccessDatabaseSysAd panel = new GUISAAccessDatabaseSysAd(null);
    }
}
