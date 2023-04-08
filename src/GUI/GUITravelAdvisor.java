package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITravelAdvisor extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JButton createCustomerButton;
    private JButton editCustomerAccountButton;
    private JButton createTicketButton;
    private JButton issueRefundButton;
    private JButton createRepBtn;

    public GUITravelAdvisor(JFrame parent) {

        super(parent);
        setTitle("Travel Advisor");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITACreateCustomer(null).setVisible(false);
                panel1.setVisible(false);
            }
        });
        editCustomerAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITAEditCustomer(null).setVisible(false);
                panel1.setVisible(false);
            }
        });
        createTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITACreateTicket(null).setVisible(false);
                panel1.setVisible(false);
            }
        });
        issueRefundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITAIssueRefund(null).setVisible(false);
                panel1.setVisible(false);

            }
        });

        createRepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITACreateReport(null).setVisible(false);
                panel1.setVisible(false);

            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        GUITravelAdvisor login = new GUITravelAdvisor(null);
    }
}

