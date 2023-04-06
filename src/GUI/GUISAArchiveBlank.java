package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAArchiveBlank extends JDialog{
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JButton removeBlankButton;
    private JButton archiveButton;
    private JButton backButton;
    private JButton logoutButton;

    public GUISAArchiveBlank(JFrame parent) {

        super(parent);
        setTitle("Archive Blank");
        setContentPane(panel1);
        setMinimumSize(new Dimension(850, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAArchiveBlank panel = new GUISAArchiveBlank(null);
    }
}
