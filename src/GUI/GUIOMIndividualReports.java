package GUI;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;

public class GUIOMIndividualReports extends JDialog {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton logOutButton;
    private JButton backButton;
    private JButton confirmButton;

    public GUIOMIndividualReports(JFrame parent) {

        super(parent);
        setTitle("Individual Report");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);



    }



    public static void main(String[] args) {
        GUIOMIndividualReports panel = new GUIOMIndividualReports(null);
    }
}
