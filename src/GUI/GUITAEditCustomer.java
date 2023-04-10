package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITAEditCustomer extends JDialog{
    private JPanel panel1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JCheckBox regularCheckBox;
    private JCheckBox valuedCheckBox;
    private JButton updateButton;
    private JButton logOutButton;
    private JButton backButton;

    public GUITAEditCustomer(JFrame parent) {

        super(parent);
        setTitle("Edit Customer");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITravelAdvisor(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        GUITAEditCustomer login = new GUITAEditCustomer(null);
    }
}

