package GUI;

import Backend.persistenceLayer.User;
import Backend.persistenceLayer.UserType;
import MySQL.UserController;

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
    private JTextField IDtf;
    private JTextField userNametf;
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
                if ( userNametf.getText().equals("") || emailtf.getText().equals("")
                        || passWordtf.getText().equals("") || userTypetf.getText().equals("")) {
                    error();
                } else if (!userTypetf.getText().equals("SystemAdmin") && !userTypetf.getText().equals("OfficeManager")
                        && !userTypetf.getText().equals("TravelAdvisor")) {
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "User type not recognised");
                } else {
                    User user = new User(userNametf.getText(), passWordtf.getText(), emailtf.getText(), 1,
                            UserType.valueOf(userTypetf.getText().replace(" ", "")), false);

                    //adding to table
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    UserController userController = new UserController();
                    userController.createUser(user);
                    model.addRow(new Object[]{user.getId(), userNametf.getText(), emailtf.getText(), passWordtf.getText(), user.getUserType().toString()});
                    System.out.println("hello");
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Staff account added!");
                }
            }
        });
        archiveStaffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                UserController userController = new UserController();
                int selectedRow = table1.getSelectedRow();
                if(selectedRow != -1) {
                    int id = (int) model.getValueAt(selectedRow, 0);
                    userController.archiveUser(id);
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Staff account archived!");
                } else {
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this, "Please select a row!");
                }
            }
        });

        updateStaffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get table model
                User user = new User(userNametf.getText(), passWordtf.getText(), emailtf.getText(), 1,
                        UserType.valueOf(userTypetf.getText().replace(" ", "")), false);

                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                // if a row is selected then update

                  if(IDtf.getText().equals("") || userNametf.getText().equals("") || emailtf.getText().equals("")
                        || passWordtf.getText().equals("") || userTypetf.getText().equals("")) {
                    error();}
                else if(!userTypetf.getText().equals("SystemAdmin") && !userTypetf.getText().equals("OfficeManager" )&&
                        !userTypetf.getText().equals( "TravelAdvisor")){
                    JOptionPane.showMessageDialog(GUISAManageStaffAccount.this,"User type not recognised");}
                else if (table1.getSelectedRow() != -1) {
                    String id = IDtf.getText();
                    String userName = userNametf.getText();
                    String email = emailtf.getText();
                    String passWord = passWordtf.getText();
                    String userType = userTypetf.getText();

                    // Set updated value in the table

                    table1.setValueAt(id, table1.getSelectedRow(), 0);
                    table1.setValueAt(userName, table1.getSelectedRow(), 1);
                    table1.setValueAt(email, table1.getSelectedRow(), 2);
                    table1.setValueAt(passWord, table1.getSelectedRow(), 3);
                    table1.setValueAt(userType, table1.getSelectedRow(), 4);

                    UserController userController = new UserController();
                    userController.updateUser(user);
                      System.out.println("hello");


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
                new String [] {"ID", "Username", "Email", "Password", "User Type"}

        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        UserController userController = new UserController();

        for (User user : userController.getActiveUsers()) {
            model.addRow(new Object[]{user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getUserType()});
        }

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