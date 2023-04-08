package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITACreateCustomer extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField fNametf;
    private JTextField lNametf;
    private JTextField aliastf;
    private JTextField phonetf;
    private JTextField emailtf;
    private JRadioButton regRadio;
    private JRadioButton valRadio;
    private JButton createButton;
    private JButton backButton;
    private JTextField idtf;
    private JTable table1;
    private JButton updateButton;
    private JButton archiveButton;
    private JTextField cusTypetf;

    public GUITACreateCustomer(JFrame parent) {

        super(parent);
        setTitle("Create Customer");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(650, 700));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITravelAdvisor(null).setVisible(false);
                panel1.setVisible(false);
            }
        });


                createButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (idtf.getText().equals("") || fNametf.getText().equals("") || lNametf.getText().equals("") ||
                                aliastf.getText().equals("") ||
                                phonetf.getText().equals("") || emailtf.getText().equals("") || cusTypetf.getText().equals("")) {
                            JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Please enter all data!");
                        } else if (!cusTypetf.getText().equals("Regular") && !cusTypetf.getText().equals("Valued") &&
                                !cusTypetf.getText().equals("valued") && !cusTypetf.getText().equals("regular")) {
                            JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Customer type not recognised");
                        } else {
                            DefaultTableModel model = (DefaultTableModel) table1.getModel();
                            model.addRow(new Object[]{idtf.getText(), fNametf.getText(), lNametf.getText(), aliastf.getText(),
                                    phonetf.getText(), emailtf.getText(), cusTypetf.getText()});
                            JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Staff account added!");
                        }

                    }
                });

        archiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                if(table1.getSelectedRow()!=-1) {
                    //if a row is selected in the table
                    model.removeRow(table1.getSelectedRow());
                    JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Customer account archived!");
                }else if(table1.getRowCount()==0){
                    JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Select row!");
                    // If the table is empty with 0 rows
                }else{
                    JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Please select a row!");
                }
            }

        });


                updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get table model
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                // if a row is selected then update
                if(!cusTypetf.getText().equals("Regular") && !cusTypetf.getText().equals("Valued") &&
                        !cusTypetf.getText().equals("valued") && !cusTypetf.getText().equals("regular")){
                    JOptionPane.showMessageDialog(GUITACreateCustomer.this,"Customer type not recognised");}
                else if (table1.getSelectedRow() != -1) {
                    String id = idtf.getText();
                    String fName = fNametf.getText();
                    String lName = lNametf.getText();
                    String alias = aliastf.getText();
                    String phoneNumber = phonetf.getText();
                    String email = emailtf.getText();
                    String cusType = cusTypetf.getText();

                    // Set updated value in the table

                    table1.setValueAt(id,table1.getSelectedRow(),0);
                    table1.setValueAt(fName, table1.getSelectedRow(), 1);
                    table1.setValueAt(lName, table1.getSelectedRow(), 2);
                    table1.setValueAt(alias, table1.getSelectedRow(), 3);
                    table1.setValueAt(phoneNumber, table1.getSelectedRow(), 4);
                    table1.setValueAt(email, table1.getSelectedRow(), 5);
                    table1.setValueAt(cusType, table1.getSelectedRow(),6);


                    // Update message pop up

                    JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Update Successful!");
                } else {
                    if (table1.getSelectedRow() == 0) {
                        JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Select Row!");
                    }
                }
            }
        });



        setVisible(true);
    }



    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,
                new String [] {"ID", "First Name", "Last Name", "Alias","Phone Number", "Email", "Customer Type"}

        ));

    }
    public static void main(String[] args) {
        GUITACreateCustomer login = new GUITACreateCustomer(null);
    }
}

