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



        setVisible(true);

    }

    private void createTable() {
        table2.setModel(new DefaultTableModel(
                null,
                new String[]{"ID", "Name", "Last Name","Alias", "Phone Number", "Email Address", "isValued", "isRegular"     }


        ));
    }

    public static void main(String[] args) {
        GUITACreateCustomer login = new GUITACreateCustomer(null);
    }
}

