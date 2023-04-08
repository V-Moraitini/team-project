package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISAAccessBlankStock extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JButton backButton;
    private JTable table1;
    private JButton addBlankButton;
    private JButton archiveBlankButton;


    public GUISAAccessBlankStock(JFrame parent) {

        super(parent);
        setTitle("Access Blank Stock");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                panel1.setVisible(false);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISystemAdmin(null).setVisible(false);
                panel1.setVisible(false);
            }
        });
        addBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAAddNewBlank(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        archiveBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAArchiveBlank(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        setVisible(true);



    }

    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,
                new String [] {"Blank ID", "Quantity", "Blank Type"}
        ));}

    public static void main(String[] args) {
        GUISAAccessBlankStock panel = new GUISAAccessBlankStock(null);
    }
}