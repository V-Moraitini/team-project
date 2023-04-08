package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISASearchTravelAdvisor extends JDialog {
    private JPanel panel1;
    private JButton searchTravelAdvisorIDButton;
    private JTextField textField1;
    private JButton searchButton;
    private JList list1;
    private JList list2;
    private JList list3;
    private JButton backButton;
    private JButton editSelectedAccountButton;
    private JButton logoutButton;

    public GUISASearchTravelAdvisor(JFrame parent) {

        super(parent);
        setTitle("Search Travel Advisor");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUISASearchTravelAdvisor panel = new GUISASearchTravelAdvisor(null);
    }
}
