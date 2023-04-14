package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITAIssueRefund extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JTable table1;
    private JButton backButton;
    private JButton issueRefundButton;
    private JTextField custIDtf;
    private JTextField saleIDtf;
    private JTextField amountTf;
    private JTextField cardDetailstf;
    private JTextField datetf;
    private JTextField blanktf;

    public GUITAIssueRefund(JFrame parent) {

        super(parent);
        setTitle("Issue Refund");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITravelAdvisor(null).setVisible(false);
                panel1.setVisible(false);
            }
        });



        issueRefundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (custIDtf.getText().isEmpty() ||blanktf.getText().isEmpty() || saleIDtf.getText().isEmpty() ||
                        amountTf.getText().isEmpty() || amountTf.getText().isEmpty() ||
                        datetf.getText().isEmpty()){

                    // Show error message if not all required fields are filled
                    JOptionPane.showMessageDialog(null, "Please fill all required fields", "Error", JOptionPane.ERROR_MESSAGE);

                } else{
                    // Create a sale if all required fields are filled
                    // Code for creating a sale here

                    // Show success message
                    JOptionPane.showMessageDialog(null, blanktf.getText() + "returned and full refund given", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        setVisible(true);

    }

    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,
                new String [] {"Customer ID", "Sales ID", "Amount", "Card Details", "Date"}
        ));}

    public static void main(String[] args) {
        GUITAIssueRefund login = new GUITAIssueRefund(null);
    }
}

