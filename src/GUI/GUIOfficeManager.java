package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class GUIOfficeManager extends JDialog {
    private JPanel mainPanel;
    private JButton BtnGenRep;
    private JButton BtnSeDisPlan;
    private JButton btnAccessBStock;
    private JButton btnAssBStock;
    private JButton btnLogOut;
    private JButton reassignBlankButton;


    public GUIOfficeManager(JFrame parent){

        super(parent);
        BtnGenRep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==BtnGenRep){ //when you click on the generate report button , it goes the frame with different types of report
                    dispose();// gets rid of the current frame once you click on the button to lead to another frame
                    GUIOMCreateReport gr = new GUIOMCreateReport(null);
                    gr.setVisible(false);
                    //close();
                    mainPanel.setVisible(false);
                }
            }
        });

        BtnSeDisPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==BtnSeDisPlan){ //when you click on the set discount button it goes to the discount page
                    dispose(); // get rids of current frame to go to the new frame
                    GUIOMSetDiscountPlan sd = new GUIOMSetDiscountPlan(null);
                    sd.setVisible(false);
                    //close();
                    mainPanel.setVisible(false);
                }
            }
        });



        btnLogOut.addActionListener(new ActionListener() { // log out button
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==btnLogOut){ //when you click on the reassign button it goes to the reassign  page
                    dispose(); // get rids of current frame to go to the new frame
                    GUILogin lo = new GUILogin(null);
                    lo.setVisible(false);
                    //close();
                    mainPanel.setVisible(false);
                }
            }
        });

        btnAccessBStock.addActionListener(new ActionListener() { // log out button
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==btnAccessBStock){ //when you click on the reassign button it goes to the reassign  page
                    dispose(); // get rids of current frame to go to the new frame
                    GUIOMAccessBlankStock lo = new GUIOMAccessBlankStock(null);
                    lo.setVisible(false);
                    //close();
                    mainPanel.setVisible(false);
                }
            }
        });

        setTitle("Office Manager");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(420, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }


   public static void main(String[] args) {
        GUIOfficeManager panel = new GUIOfficeManager(null);
    }


}

