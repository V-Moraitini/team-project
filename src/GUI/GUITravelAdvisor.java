package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITravelAdvisor extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JButton createCustomerButton;
    private JButton editCustomerAccountButton;
    private JButton createTicketButton;
    private JButton issueRefundButton;
    private JButton backButton;

    public GUITravelAdvisor(JFrame parent) {

        super(parent);
        setTitle("Travel Advisor");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITravelAdvisor login = new GUITravelAdvisor(null);
    }
}

