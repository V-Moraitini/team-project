package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIOMAssignBlanks extends JDialog {
    private JPanel mainPanel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton saveButton;
    private JButton backButton;
    private JButton logoutButton;


        public GUIOMAssignBlanks(JFrame parent) {

            super(parent);
            setTitle("Access Blank Stock");
            setContentPane(mainPanel);
            setMinimumSize(new Dimension(450, 300));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);

        }

        public static void main(String[] args) {
            GUIOMAssignBlanks panel = new GUIOMAssignBlanks(null);
        }
    }


