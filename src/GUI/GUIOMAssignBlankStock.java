package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIOMAssignBlankStock extends JDialog {
    private JPanel panel1;
    private JButton reassignBlankButton;
    private JButton assignBlankButton;
    private JButton logoutButton;
    private JButton backButton;



    public GUIOMAssignBlankStock(JFrame parent) {

        super(parent);
        setTitle("Assign Blank Stock");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOMAssignBlankStock panel = new GUIOMAssignBlankStock(null);
    }
}
