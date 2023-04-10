package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITravelAdvisor(null).setVisible(false);
                panel.setVisible(false);
            }
        });


        createIndividualDomesticReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITACreateDomReport(null).setVisible(false);
                panel.setVisible(false);
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        GUITACreateReport login = new GUITACreateReport(null);
    }
}

