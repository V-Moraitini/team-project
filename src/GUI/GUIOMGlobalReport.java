package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOMGlobalReport extends JDialog{
    private JPanel mainPanel;
    private JButton accessIndividualReportsButton;
    private JButton createGlobalInterlineReportButton;
    private JButton createGlobalDomesticReportButton;
    private JButton logOutButton;
    private JButton backButton;


    public GUIOMGlobalReport(JFrame parent) {

        super(parent);
        setTitle("Create Report");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(450, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOfficeManager(null).setVisible(false);
                setVisible(false);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                setVisible(false);
            }
        });
        accessIndividualReportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOMInterlineReports(null).setVisible(false);
                setVisible(false);
            }
        });
        createGlobalInterlineReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                setVisible(false);
            }
        });
        createGlobalDomesticReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        GUIOMGlobalReport panel = new GUIOMGlobalReport(null);
    }
}

