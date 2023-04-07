package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUISAArchiveBlank extends JDialog{
    private JPanel panel1;
    private JTable table1;
    private JButton logOutButton;
    private JButton archiveButton;
    private JButton backButton;

    public GUISAArchiveBlank(JFrame parent) {

        super(parent);
        setTitle("Archive Blank");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(850, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }
    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,
                new String [] {"Available Blanks", "Blank ID"}
        ));}

    public static void main(String[] args) {
        GUISAArchiveBlank panel = new GUISAArchiveBlank(null);
    }
}
