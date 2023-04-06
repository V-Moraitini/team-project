package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIOMAccessBlankStock extends JDialog {
    private JPanel mainPanel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton saveButton;
    private JButton backButton;
    private JButton searchButton;
    private JButton logoutButton;


        public GUIOMAccessBlankStock(JFrame parent) {

            super(parent);
            setTitle("Access Blank Stock");
            setContentPane(mainPanel);
            setMinimumSize(new Dimension(450, 274));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);

        }

        public static void main(String[] args) {
            GUI.GUIOMAccessBlankStock panel = new GUI.GUIOMAccessBlankStock(null);
        }
    }


