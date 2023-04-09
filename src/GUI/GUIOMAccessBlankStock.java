package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUIOMAccessBlankStock extends JDialog {

    private JPanel panel1;
    private JTable table2;
    private JButton logOutButton;
    private JButton backButton;
    private JButton addBlankButton;
    private JButton archiveBlankButton;

    public GUIOMAccessBlankStock(JFrame parent) {

        super(parent);
        setTitle("Access Blank Stock");
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        createTable();
        setVisible(true);

    }


    public void close(){
        panel1.setVisible(false);
    }


        private void createTable(){
        table2.setModel(new DefaultTableModel(
                null,
                new String [] {"Available Blanks", "Blank ID"}
        ));

    }

    public static void main(String[] args) {

        GUIOMAccessBlankStock  panel1 = new GUIOMAccessBlankStock(null);
    }
}


