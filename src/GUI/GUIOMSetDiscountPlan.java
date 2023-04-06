package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIOMSetDiscountPlan extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JButton searchButton;
    private JButton searchButton1;
    private JRadioButton fixedRadioButton;
    private JRadioButton flexibleRadioButton;
    private JTextField textField3;
    private JButton applyButton;
    private JButton backButton;
    private JButton logoutButton;
    private JPanel panel1;

    public GUIOMSetDiscountPlan(JFrame parent) {

        super(parent);
        setTitle("Set Discount Plan");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOMSetDiscountPlan panel = new GUIOMSetDiscountPlan(null);
    }
}
