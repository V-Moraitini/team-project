package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITACreateTicket2 extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JCheckBox yesCheckBox;
    private JCheckBox noCheckBox;
    private JTextField textField2;
    private JCheckBox cashCheckBox;
    private JCheckBox cardCheckBox;
    private JButton proceedToPaymentButton;
    private JButton backButton;

    public GUITACreateTicket2(JFrame parent) {

        super(parent);
        setTitle("Create Ticket 2");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITACreateTicket2 login = new GUITACreateTicket2(null);
    }
}

