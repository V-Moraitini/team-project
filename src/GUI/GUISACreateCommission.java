package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISACreateCommission extends JDialog {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton createCommissionRateButton;
    private JButton logoutButton;
    private JButton backButton;

    public GUISACreateCommission(JFrame parent) {

        super(parent);
        setTitle("Create Commission");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISACreateCommission panel = new GUISACreateCommission(null);
    }

}
