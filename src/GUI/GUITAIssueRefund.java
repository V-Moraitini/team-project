package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUITAIssueRefund extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JTable table1;
    private JButton backButton;
    private JButton issueRefundButton;

    public GUITAIssueRefund(JFrame parent) {

        super(parent);
        setTitle("Issue Refund");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

