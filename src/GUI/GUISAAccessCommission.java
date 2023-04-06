package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAAccessCommission extends JDialog {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton archiveCommissionRateButton;
    private JButton editCommissionRateButton;
    private JButton backButton;
    private JButton logoutButton;

    public GUISAAccessCommission(JFrame parent) {

        super(parent);
        setTitle("Access Commission");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAAccessCommission panel = new GUISAAccessCommission(null);
    }
}
