package GUI;

//import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOMIndividualReports extends JDialog {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton logOutButton;
    private JButton backButton;
    private JButton confirmButton;
    private JTextField xxXxXxTextField;

    public GUIOMIndividualReports(JFrame parent) {

        super(parent);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==backButton){ //when you click on the button another frame appears
                    dispose();
                    GUIOMCreateReport gc = new GUIOMCreateReport(null);
                    gc.setVisible(false);
                    //close();
                    panel1.setVisible(false);



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
                    panel1.setVisible(false);

                }

            }
        });

        setTitle("Individual Report");
        setContentPane(panel1);
        setMinimumSize(new Dimension(700, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);



    }



    public static void main(String[] args) {
        GUIOMIndividualReports panel = new GUIOMIndividualReports(null);
    }
}
