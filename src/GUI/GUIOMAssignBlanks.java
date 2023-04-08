package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOMAssignBlanks extends JDialog {
    private JPanel mainPanel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton saveButton;
    private JButton backButton;
    private JButton logoutButton;


        public GUIOMAssignBlanks(JFrame parent) {

            super(parent);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (e.getSource()==backButton){ //when you click on the set discount button it goes to the discount page
                        dispose();
                        GUIOfficeManager off = new GUIOfficeManager(null);
                        off.setVisible(false);
                        //close();
                        mainPanel.setVisible(false);

                    }

                }
            });
            setTitle("Assign Blanks");
            setContentPane(mainPanel);
            setMinimumSize(new Dimension(450, 300));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);


        }

        public static void main(String[] args) {
            GUIOMAssignBlanks panel = new GUIOMAssignBlanks(null);
        }
    }


