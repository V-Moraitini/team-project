package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISAEditSelectedAccount extends JDialog {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton backButton;
    private JButton logoutButton;

    public GUISAEditSelectedAccount(JFrame parent) {

        super(parent);
        setTitle("Edit Selected Account");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISAEditSelectedAccount panel = new GUISAEditSelectedAccount(null);
    }
}
