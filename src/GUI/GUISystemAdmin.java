package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISystemAdmin extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JButton accessBlankStockButton;
    private JButton manageStaffAccountButton;
    private JButton accessDatabaseButton;
    private JButton accessCommissionButton;
    private JButton createCommissionButton;
    private JButton backButton;
    private DefaultTableModel model1;

    public GUISystemAdmin(JFrame parent) {

        super(parent);
        setTitle("System Administrator");
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      accessBlankStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAAccessBlankStock(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        manageStaffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAManageStaffAccount(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        accessDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAAccessDatabase(null).setVisible(false);
                panel1.setVisible(false);

            }
        });

        accessCommissionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAAccessCommission(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        createCommissionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISACreateCommission(null).setVisible(false);
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
        GUISystemAdmin panel = new GUISystemAdmin(null);
    }
}
