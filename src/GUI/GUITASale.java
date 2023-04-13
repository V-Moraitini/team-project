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
        setMinimumSize(new Dimension(700, 600));
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

        createTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if all required fields are filled
                if (advisorNametf.getText().isEmpty() || blankNumbertf.getText().isEmpty() ||
                        origintf.getText().isEmpty() || destinationtf.getText().isEmpty() ||
                        localCurrencytf.getText().isEmpty() || localtf.getText().isEmpty() ||
                        othertf.getText().isEmpty() || comRatetf.getText().isEmpty() ||
                        (!domesticRadioButton.isSelected() && !interlineRadioButton.isSelected()) ||
                        (!cardRadioButton.isSelected() && !cashRadioButton.isSelected() && !payLaterRadioButton.isSelected())) {

                    // Show error message if not all required fields are filled
                    JOptionPane.showMessageDialog(null, "Please fill all required fields", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // Create a sale if all required fields are filled
                    // Code for creating a sale here

                    // Show success message
                    JOptionPane.showMessageDialog(null, "Sale created", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        GUITASale login = new GUITASale(null);
    }
}

