package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOMSetDiscountPlan extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton fixedRadioButton;
    private JRadioButton flexibleRadioButton;
    private JTextField textField3;
    private JButton confirmButton;
    private JButton backButton;

    public GUIOMSetDiscountPlan(JFrame parent) {

        super(parent);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==backButton){ //when you click on the back button it leads to the office manager main page
                    dispose();
                    GUIOfficeManager gr = new GUIOfficeManager(null);
                    gr.setVisible(false);
                    //close();
                    panel1.setVisible(false);



                }

            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==logOutButton){ //when you click on the reassign button it goes to the reassign  page
                    dispose(); // get rids of current frame to go to the new frame
                    GUILogin lo = new GUILogin(null);
                    lo.setVisible(false);
                    //close();
                    panel1.setVisible(false);

                }

            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  JOptionPane.showMessageDialog(GUIOMSetDiscountPlan.this,"enter digits");

            }
        });

        setTitle("Set Discount Plan");
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 350));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);



    }

    public static void main(String[] args) {
        GUIOMSetDiscountPlan panel = new GUIOMSetDiscountPlan(null);
    }
}
