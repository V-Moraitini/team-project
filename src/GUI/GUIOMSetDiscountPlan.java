package GUI;

import javax.swing.*;
import java.awt.*;

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
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOMSetDiscountPlan panel = new GUIOMSetDiscountPlan(null);
    }
}
