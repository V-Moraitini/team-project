package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITACreateReport2 extends JDialog{
    private JPanel panel1;
    private JButton backButton;
    private JButton createButton;
    private JButton logOutButton;

    public GUITACreateReport2(JFrame parent) {

        super(parent);
        setTitle("Create Report 2");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITACreateReport2 login = new GUITACreateReport2(null);
    }
}

