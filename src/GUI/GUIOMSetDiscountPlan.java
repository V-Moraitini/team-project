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
        setTitle("Set Discount Plan");
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 350));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user inputs
                double price = Double.parseDouble(textField1.getText());
                int quantity = Integer.parseInt(textField2.getText());
                double discountRate = Double.parseDouble(textField3.getText());

                // Calculate the discount
                double discount = 0.0;
                if (fixedRadioButton.isSelected()) {
                    discount = discountRate;
                } else if (flexibleRadioButton.isSelected()) {
                    discount = price * quantity * discountRate / 100.0;
                }

                // Display the discount
                JOptionPane.showMessageDialog(panel1, "The discount is: $" + discount);
            }
        });
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOMSetDiscountPlan panel = new GUIOMSetDiscountPlan(null);
    }
}
