package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GUISAAccessBlankStock extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JButton backButton;
    private JTable table1;
    private JButton addBlankButton;
    private JButton archiveBlankButton;
    private JTextField blankIDtf;
    private JTextField qtytf;
    private JTextField blankTypetf;
    private JTextField datetf;
    private DefaultTableModel model;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
    Date date = new Date();
    Calendar cal = Calendar.getInstance();

    public GUISAAccessBlankStock(JFrame parent) {

        super(parent);
        setTitle("Access Blank Stock");
        model = (DefaultTableModel) table1.getModel();
        datetf.setText(" " + dateFormat.format(date));
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 700));
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
                if (blankIDtf.getText().equals("") ||qtytf.getText().equals("") || blankTypetf.getText().equals("")) {
                    error();
                }else{
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.addRow(new Object[]{blankIDtf.getText(),qtytf.getText(),blankTypetf.getText(),datetf.getText()});
                } }
        });

        archiveBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                if(table1.getSelectedRow()!=-1) {
                //if a row is selected in the table
                model.removeRow(table1.getSelectedRow());
                }else if(table1.getRowCount()==0){
                        JOptionPane.showMessageDialog(GUISAAccessBlankStock.this, "Select row");
                    // If the table is empty with 0 rows
                }else{
                    JOptionPane.showMessageDialog(GUISAAccessBlankStock.this, "Please select a row");
                }
                }

        });

        setVisible(true);



    }

    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,
                new String [] {"Blank ID", "Quantity", "Blank Type", "Date"}


        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
    }


    private void error(){
        JOptionPane.showMessageDialog(this, "Please enter all data");
    }

    public static void main(String[] args) {
        GUISAAccessBlankStock panel = new GUISAAccessBlankStock(null);
    }
}