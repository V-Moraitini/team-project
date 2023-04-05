package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITACreateTicket2 extends JDialog{
    private JPanel panel1;
    private JTextField textField1;
    private JButton searchButton;
    private JTextField textField2;
    private JTextField textField3;
    private JButton logoutButton;
    private JButton proceedWithPaymentButton;
    private JButton backButton;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JRadioButton cashRadioButton;
    private JRadioButton cardRadioButton;

    public GUITACreateTicket2(JFrame parent) {

        super(parent);
        setTitle("Create Ticket 2");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITACreateTicket2 login = new GUITACreateTicket2(null);
    }
}

