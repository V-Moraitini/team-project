package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOfficeManager extends JDialog {
    private JPanel mainPanel;
    private JButton BtnGenRep;
    private JButton BtnSeDisPlan;
    private JButton btnAccessBStock;
    private JButton btnAssBStock;
    private JButton btnLogOut;


    public GUIOfficeManager(JFrame parent) {

        super(parent);
        setTitle("Office Manager");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOfficeManager panel = new GUIOfficeManager(null);
    }
}
