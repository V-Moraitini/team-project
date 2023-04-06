package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITAIssueRefund extends JDialog{
    private JPanel panel1;
    private JTextField textField1;
    private JButton searchButton;
    private JButton logoutButton;
    private JButton backButton;
    private JButton issueRefundButton;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JList list5;

    public GUITAIssueRefund(JFrame parent) {

        super(parent);
        setTitle("Issue Refund");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITAIssueRefund login = new GUITAIssueRefund(null);
    }
}

