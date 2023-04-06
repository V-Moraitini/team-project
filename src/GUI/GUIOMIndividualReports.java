package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIOMIndividualReports extends JDialog {
    private JButton searchTravelAdvisorIDButton;
    private JTextField chooseStartDateTextField;
    private JTextField chooseEndDateTextField;
    private JTextField textField1;
    private JFormattedTextField xxXxXxFormattedTextField;
    private JFormattedTextField xxXxXxFormattedTextField1;
    private JButton logoutButton;
    private JButton backButton;
    private JPanel panel1;

    public GUIOMIndividualReports(JFrame parent) {

        super(parent);
        setTitle("Individual Report");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOMIndividualReports panel = new GUIOMIndividualReports(null);
    }
}
