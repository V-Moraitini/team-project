package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITAProceedWithPayment extends JDialog {
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton logOutButton;
    private JButton backButton;
    private JButton saveButton;

    public GUITAProceedWithPayment(JFrame parent) {

        super(parent);
        setTitle("Proceed with payment");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITAProceedWithPayment login = new GUITAProceedWithPayment(null);
    }
}

