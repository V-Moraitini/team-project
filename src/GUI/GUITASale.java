package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITASale extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField advisorNametf;
    private JRadioButton domesticRadioButton;
    private JRadioButton interlineRadioButton;
    private JTextField blankNumbertf;
    private JTextField origintf;
    private JTextField destinationtf;
    private JTextField localCurrencytf;
    private JTextField localtf;
    private JTextField othertf;
    private JButton createTicketButton;
    private JButton backButton;
    private JRadioButton cardRadioButton;
    private JRadioButton cashRadioButton;
    private JRadioButton payLaterRadioButton;
    private JTextField textField1;
    private JTextField comRatetf;
    private JTextField aliastf;

    public GUITASale(JFrame parent) {

        super(parent);
        setTitle("Create Ticket");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 600));
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

        setVisible(true);

    }

    public static void main(String[] args) {
        GUITASale login = new GUITASale(null);
    }
}

