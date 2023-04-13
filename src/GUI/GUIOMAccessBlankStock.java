package GUI;

import Backend.persistenceLayer.Blank;
import Backend.persistenceLayer.User;
import Backend.persistenceLayer.UserType;
import MySQL.BlankController;
import MySQL.UserController;
import Backend.persistenceLayer.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIOMAccessBlankStock extends JDialog {

    private JPanel panel1;
    private JTable table2;
    private JButton logOutButton;
    private JButton backButton;
    private JButton assignBlankButton;
    private JButton reassignBlankButton;
    private JButton searchButton;
    private JTextField advisorIDtf;

    public GUIOMAccessBlankStock(JFrame parent) {

        super(parent);
        setTitle("Access Blank Stock");
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        createTable();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOfficeManager(null).setVisible(false);
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


        assignBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        reassignBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table2.getModel();
                BlankController blankController = new BlankController();

                for (Blank blank : blankController.getActiveBlanks()) {
                    model.addRow(new Object[]{blank.getBlankId(), blank.getBlankType(), blank.getBlankDateReceived()});
                }
            }
        });


        assignBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table2.getSelectedRow();
                if (selectedRow != -1) {
                    int blankId = Integer.parseInt(table2.getValueAt(selectedRow, 0).toString());
                    int advisorId = Integer.parseInt(advisorIDtf.getText());
                    BlankController blankController = new BlankController();
                    blankController.updateBlankStockAdvisorId(blankId, advisorId);
                } else {
                    // Display an error message to the user indicating that no row is selected.
                    JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }


    public void close(){
        panel1.setVisible(false);
    }


        private void createTable(){
        table2.setModel(new DefaultTableModel(
                null,
                new String [] {"Blank ID", "Blank Type"}
        ));

    }

    public static void main(String[] args) {

        GUIOMAccessBlankStock  panel1 = new GUIOMAccessBlankStock(null);
    }
}


