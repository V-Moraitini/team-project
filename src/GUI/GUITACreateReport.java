package GUI;

import javax.swing.*;
import java.awt.*;

public class GUITACreateReport extends JDialog {
    private JPanel panel;
    private JButton logOutButton;
    private JButton createIndividualDomesticReportButton;
    private JButton createIndividualInterlineReportButton;
    private JButton backButton;

    public GUITACreateReport(JFrame parent) {

        super(parent);
        setTitle("Create Report");
        setContentPane(panel);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUITACreateReport login = new GUITACreateReport(null);
    }
}

