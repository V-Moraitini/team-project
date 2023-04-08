package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITACreateTicket extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField textField1;
    private JRadioButton domesticRadioButton;
    private JRadioButton interlineRadioButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton createTicketButton;
    private JButton backButton;

    public GUITACreateTicket(JFrame parent) {

        super(parent);
        setTitle("Create Ticket");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITACreateTicket login = new GUITACreateTicket(null);
    }
}

