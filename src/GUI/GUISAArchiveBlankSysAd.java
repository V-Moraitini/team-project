package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAArchiveBlankSysAd extends JDialog {
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JButton removeBlankButton;
    private JButton archiveButton;
    private JButton backButton;
    private JButton logoutButton;


    public GUISAArchiveBlankSysAd(JFrame parent) {

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
        GUISAArchiveBlankSysAd panel = new GUISAArchiveBlankSysAd(null);
    }
}