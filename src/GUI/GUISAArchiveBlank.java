package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISAArchiveBlank extends JDialog{
    private JPanel panel1;
    private JTable table1;
    private JButton logOutButton;
    private JButton archiveButton;
    private JButton backButton;
    private DefaultTableModel model1;

    public GUISAArchiveBlank(JFrame parent) {

        super(parent);
        setTitle("Archive Blank");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(850, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAAccessBlankStock(null).setVisible(false);
                panel1.setVisible(false);
            }
        });
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
