package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOMAssignBlankStock extends JDialog {
    private JPanel panel1;
    private JButton reassignBlankButton;
    private JButton assignBlankButton;
    private JButton logoutButton;
    private JButton backButton;



    public GUIOMAssignBlankStock(JFrame parent) {

        super(parent);
        setTitle("Assign Blank Stock");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        reassignBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==reassignBlankButton) { //when you click on the reassign button it goes to the reassign  page
                    dispose(); // get rids of current frame to go to the new frame
                    GUIOMReassignBlank rbb = new GUIOMReassignBlank(null);
                    rbb.setVisible(false);
                    //close();
                    panel1.setVisible(false);


                }

            }
        });

        assignBlankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        GUIOMAssignBlankStock panel = new GUIOMAssignBlankStock(null);
    }
}

