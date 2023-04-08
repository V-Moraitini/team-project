package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GUISAAccessCommission extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField comRatetf;
    private JButton arcCMRBtn;
    private JButton editCMRBtn;
    private JButton backButton;
    private JTextField blankTypetf;
    private JButton createButton;
    private JLabel date;
    private JTextField datetf;
    private JTable table1;
    private DefaultTableModel model;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
    Date date1 = new Date();
    Calendar cal = Calendar.getInstance();

    public GUISAAccessCommission(JFrame parent) {

        super(parent);
        setTitle("Access Commission");
        model = (DefaultTableModel) table1.getModel();
        datetf.setText(" " + dateFormat.format(date1));
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 700));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (blankTypetf.getText().equals("") ||comRatetf.getText().equals("")||datetf.getText().equals("")) {
                    error();
                }else{
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.addRow(new Object[]{blankTypetf.getText(),comRatetf.getText(),datetf.getText()});
                } }
        });

        arcCMRBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                if(table1.getSelectedRow()!=-1) {
                    //if a row is selected in the table
                    model.removeRow(table1.getSelectedRow());
                }else if(table1.getRowCount()==0){
                    JOptionPane.showMessageDialog(GUISAAccessCommission.this, "Select row");
                    // If the table is empty with 0 rows
                }else{
                    JOptionPane.showMessageDialog(GUISAAccessCommission.this, "Please select a row");
                }
            }

        });

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

       editCMRBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get table model
                DefaultTableModel model = (DefaultTableModel) table1.getModel();

                // if a row is selected then update

                if(table1.getSelectedRow()!=-1) {
                    String blankType = blankTypetf.getText();
                    String comRate = comRatetf.getText();

                // Set updated value in the table

                    table1.setValueAt(blankType,table1.getSelectedRow(),0);
                    table1.setValueAt(comRate,table1.getSelectedRow(),1);

                    // Update message pop up

                    JOptionPane.showMessageDialog(GUISAAccessCommission.this,"Update Successful");
                }else{
                    if (table1.getSelectedRow() == 0) {
                        JOptionPane.showMessageDialog(GUISAAccessCommission.this,"Select Row");
                    }

                }
            }

            // Set to text field

        });

        setVisible(true);
    }
    private void createTable() {
        table1.setModel(new DefaultTableModel(
                null,
                new String[]{"Blank Type", "Commission Rate", "Date"}


        ));
    }

    private void error(){
        JOptionPane.showMessageDialog(this, "Please enter all data");
    }
        public static void main(String[] args) {
        GUISAAccessCommission panel = new GUISAAccessCommission(null);
    }
}
