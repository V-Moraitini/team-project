package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITACreateCustomer extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JRadioButton regularRadioButton;
    private JRadioButton valuedRadioButton;
    private JButton createButton;
    private JButton backButton;
    private JTextField textField6;

    public GUITACreateCustomer(JFrame parent) {

        super(parent);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==backButton){ //when you click on the button another frame appears
                    dispose();
                    GUITravelAdvisor gc = new GUITravelAdvisor(null);
                    gc.setVisible(false);
                    //close();
                    panel1.setVisible(false);



                }


            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==logOutButton){ //when you click on the button another frame appears
                    dispose();
                    GUILogin gc = new GUILogin(null);
                    gc.setVisible(false);
                    //close();
                    panel1.setVisible(false);



                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==backButton){ //when you click on the button another frame appears
                    dispose();
                    GUITravelAdvisor gc = new GUITravelAdvisor(null);
                    gc.setVisible(false);
                    //close();
                    panel1.setVisible(false);



                }

            }
        });
        setTitle("Create Customer");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 450));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);



    }

    public static void main(String[] args) {
        GUITACreateCustomer login = new GUITACreateCustomer(null);
    }
}

