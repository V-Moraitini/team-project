package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOMReassignBlank extends JDialog {
    private JPanel panel1;
    private JButton logOutButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton saveButton;
    private JButton backButton;

    public GUIOMReassignBlank(JFrame parent) {

        super(parent);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==backButton){ //when you click on the set discount button it goes to the discount page
                    dispose();
                    GUIOfficeManager off = new GUIOfficeManager(null);
                    off.setVisible(false);
                    //close();
                    panel1.setVisible(false);

                }

            }
        });
        setTitle("Reassign Blank");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 300));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args) {
        GUIOMReassignBlank panel = new GUIOMReassignBlank(null);
    }
}
