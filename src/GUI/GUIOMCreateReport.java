package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIOMCreateReport extends JDialog{
    private JPanel mainPanel;
    private JButton accessIndividualReportsButton;
    private JButton createGlobalInterlineReportButton;
    private JButton createGlobalDomesticReportButton;
    private JButton logOutButton;
    private JButton backButton;


    public GUIOMCreateReport(JFrame parent) {

        super(parent);
        setTitle("Create Report");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(450, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOMCreateReport panel = new GUIOMCreateReport(null);
    }
}

