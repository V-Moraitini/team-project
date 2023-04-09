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

    public GUITravelAdvisor(JFrame parent) {

        super(parent);

        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==createCustomerButton){ //when you click on the create customer button it goes to the discount page
                    dispose(); // get rids of current frame to go to the new frame
                    GUITACreateCustomer cc = new GUITACreateCustomer(null);
                    cc.setVisible(false);
                    //close();
                    panel1.setVisible(false);

                }

            }
        });
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

