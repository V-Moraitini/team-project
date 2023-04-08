package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISAManageStaffAccount extends JDialog {
    private JPanel panel1;
    private JButton updateStaffAccountButton;
    private JButton createStaffAccountButton;
    private JButton archiveStaffAccountButton;
    private JButton backButton;
    private JButton logOutButton;
    private JTextField fNametf;
    private JTextField lNametf;
    private JTextField emailtf;
    private JTextField passWordtf;
    private JTextField userTypetf;
    private JTable table1;

    public GUISAManageStaffAccount(JFrame parent) {

        super(parent);
        setTitle("Manage Staff Account");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(550, 600));
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

       createStaffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fNametf.getText().equals("") ||lNametf.getText().equals("")||emailtf.getText().equals("")
                        || passWordtf.getText().equals("") || userTypetf.getText().equals("")) {
                    error();
                }else if(!userTypetf.getText().equals("System Administrator") && !userTypetf.getText().equals("Office Manager" )&&
                        !userTypetf.getText().equals( "Travel Advisor")){
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this,"User type not recognised");
                }

                else{
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.addRow(new Object[]{fNametf.getText(),lNametf.getText(),emailtf.getText(),passWordtf.getText(),userTypetf.getText()});
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this,"Staff account added!");
                } }
        });

        archiveStaffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                if(table1.getSelectedRow()!=-1) {
                    //if a row is selected in the table
                    model.removeRow(table1.getSelectedRow());
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Staff account archived!");
                }else if(table1.getRowCount()==0){
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Select row!");
                    // If the table is empty with 0 rows
                }else{
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Please select a row!");
                }
            }

        });

        updateStaffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get table model
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                 // if a row is selected then update
           if(!userTypetf.getText().equals("System Administrator") && !userTypetf.getText().equals("Office Manager" )&&
                    !userTypetf.getText().equals( "Travel Advisor")){
                JOptionPane.showMessageDialog(GUISAManageStaffAccount.this,"User type not recognised");}
               else if (table1.getSelectedRow() != -1) {
                    String fName = fNametf.getText();
                    String lName = lNametf.getText();
                    String email = emailtf.getText();
                    String passWord = passWordtf.getText();
                    String userType = userTypetf.getText();

                    // Set updated value in the table

                    table1.setValueAt(fName, table1.getSelectedRow(), 0);
                    table1.setValueAt(lName, table1.getSelectedRow(), 1);
                    table1.setValueAt(email, table1.getSelectedRow(), 2);
                    table1.setValueAt(passWord, table1.getSelectedRow(), 3);
                    table1.setValueAt(userType, table1.getSelectedRow(), 4);

                    // Update message pop up

                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Update Successful!");
                         } else {
                                if (table1.getSelectedRow() == 0) {
                                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Select Row!");
                                }
                }
            }
        });
        setVisible(true);

    }

    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,
                new String [] {"First Name", "Last Name", "Email", "Password", "User Type"}


        ));

    }

    private void error(){
        JOptionPane.showMessageDialog(this, "Please enter all data!");
    }

    private void userDeets(){
        if(userTypetf.getText() != "System Administrator" || userTypetf.getText() != "Office Manager" ||
                userTypetf.getText() != "Travel Advisor"){
            JOptionPane.showMessageDialog(GUISAManageStaffAccount.this,"User type not recognised");
        }
    }

    public static void main(String[] args) {
        GUISAManageStaffAccount panel = new GUISAManageStaffAccount(null);
    }}