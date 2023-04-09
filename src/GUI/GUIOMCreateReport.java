package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOMCreateReport extends JDialog{
    private JPanel mainPanel;
    private JButton accessIndividualReportsButton;
    private JButton createGlobalInterlineReportButton;
    private JButton createGlobalDomesticReportButton;
    private JButton logOutButton;
    private JButton backButton;


    public GUIOMCreateReport(JFrame parent) {

        super(parent);


        accessIndividualReportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==accessIndividualReportsButton){ //when you click on the button another frame appears
                    dispose();
                    GUIOMIndividualReports ir = new GUIOMIndividualReports(null);
                    ir.setVisible(false);
                    //close();
                    mainPanel.setVisible(false);



                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==backButton){ //when you click on the button another frame appears
                    dispose();
                    GUIOfficeManager ir = new GUIOfficeManager(null);
                    ir.setVisible(false);
                    //close();
                    mainPanel.setVisible(false);



                }

            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==logOutButton){ //when you click on the reassign button it goes to the reassign  page
                    dispose(); // get rids of current frame to go to the new frame
                    GUILogin lo = new GUILogin(null);
                    lo.setVisible(false);
                    //close();
                    mainPanel.setVisible(false);

                }

            }
        });
        setTitle("Create Report");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(700, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);



    }

    public static void main(String[] args) {
        GUIOMCreateReport panel = new GUIOMCreateReport(null);
    }
}

