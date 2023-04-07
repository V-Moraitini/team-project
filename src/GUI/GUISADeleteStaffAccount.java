package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUISADeleteStaffAccount extends JDialog {
    private JPanel panel1;
    private JTable table1;
    private JButton archiveButton;
    private JButton backButton;
    private JButton logOutButton;

    public GUISADeleteStaffAccount(JFrame parent) {

        super(parent);
        setTitle("Delete Staff Account");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,
                new String [] {"First Name", "Last Name", "ID"}
        ));}

    public static void main(String[] args) {
        GUISADeleteStaffAccount panel = new GUISADeleteStaffAccount(null);
    }
}
