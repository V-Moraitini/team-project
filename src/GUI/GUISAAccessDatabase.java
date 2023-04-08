package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISystemAdmin(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                panel1.setVisible(false);
            }
        });



        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAAccessDatabase panel = new GUISAAccessDatabase(null);
    }
}
