package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIAddNewBlankSysAd extends JDialog {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField xxXxXxTextField;
    private JButton saveButton;
    private JButton backButton;
    private JButton logoutButton;



    public GUIAddNewBlankSysAd(JFrame parent) {

        super(parent);
        setTitle("SystemAdmin");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIAddNewBlankSysAd panel = new GUIAddNewBlankSysAd(null);
    }
}