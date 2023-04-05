package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITACreateTicket extends JDialog{
    private JPanel panel1;
    private JRadioButton interlineRadioButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JRadioButton domesticRadioButton;
    private JButton createTicketButton;
    private JButton backButton;
    private JButton logoutButton;

    public GUITACreateTicket(JFrame parent) {

        super(parent);
        setTitle("Create Ticket");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITACreateTicket login = new GUITACreateTicket(null);
    }
}

