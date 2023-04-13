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
    private JRadioButton regularRadioButton;
    private JRadioButton valuedRadioButton;
    private JButton createButton;
    private JButton updateButton;
    private JButton archiveButton;
    private JButton backButton;
    private JTextField idtf;
    private JTable table2;

    public GUITACreateCustomer(JFrame parent) {

        super(parent);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==backButton){ //when you click on the button another frame appears
                    dispose();
                    GUITravelAdvisor gc = new GUITravelAdvisor(null);
                    gc.setVisible(false);
                    //close();
                    panel1.setVisible(false);
                }
            }
        });

        setTitle("Create Customer");
        setContentPane(panel1);
        createTable();
        setMinimumSize(new Dimension(450, 450));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==logOutButton){ //when you click on the button another frame appears
                    dispose();
                    GUILogin gc = new GUILogin(null);
                    gc.setVisible(false);
                    //close();
                    panel1.setVisible(false);
                }
            }
        });


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idtf.getText().equals("") ||fNametf.getText().equals("")||lNametf.getText().equals("") || aliastf.getText().equals("") ||
                phonetf.getText().equals("") || emailtf.getText().equals("") || (!regularRadioButton.isSelected() && !valuedRadioButton.isSelected())) {
                    JOptionPane.showMessageDialog(GUITACreateCustomer.this,"Enter all fields!");
                }else{
                    DefaultTableModel model = (DefaultTableModel) table2.getModel();
                    model.addRow(new Object[]{idtf.getText(),fNametf.getText(),lNametf.getText(), aliastf.getText(),
                            phonetf.getText(), emailtf.getText(), valuedRadioButton.isSelected(),regularRadioButton.isSelected()});
                } }
        });


        archiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table2.getModel();
                if(table2.getSelectedRow()!=-1) {
                    //if a row is selected in the table
                    model.removeRow(table2.getSelectedRow());
                    JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Customer account archived!");
                }else if(table2.getRowCount()==0){
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
                // Get table model
                DefaultTableModel model = (DefaultTableModel) table2.getModel();
                // if a row is selected then update
                if (!idtf.getText().equals("Regular") && !idtf.getText().equals("Valued")) {
                    JOptionPane.showMessageDialog(GUITACreateCustomer.this, "Customer type not recognised");
                } else if (table2.getSelectedRow() != -1) {
                    // Update the customer's type based on the value in the "idtf" text field
                    String type = idtf.getText();
                    // Update the customer's other fields here
                    String fName = fNametf.getText();
                    String lName = lNametf.getText();
                    String alias = aliastf.getText();
                    String phoneNumber = phonetf.getText();
                    String email = emailtf.getText();
                    // Update the row in the table with the new values
                    int selectedRowIndex = table2.getSelectedRow();
                    model.setValueAt(type, selectedRowIndex, 0);
                    model.setValueAt(fName, selectedRowIndex, 1);
                    model.setValueAt(lName, selectedRowIndex, 2);
                    model.setValueAt(alias, selectedRowIndex, 3);
                    model.setValueAt(phoneNumber, selectedRowIndex, 4);
                    model.setValueAt(email, selectedRowIndex, 5);
                }
            }
                });
                    setVisible(true);

                }


            private void createTable() {
                table2.setModel(new DefaultTableModel(
                        null,
                        new String[]{"ID", "Name", "Last Name", "Alias", "Phone Number", "Email Address", "isValued", "isRegular"}

                ));
            }

            public static void main(String[] args) {
                GUITACreateCustomer login = new GUITACreateCustomer(null);
            }
        }
