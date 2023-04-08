package GUI;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISAAddNewBlank extends JDialog{
    private JPanel panel1;
    private JButton logOutButton;
    private JButton backButton;
    private JButton confirmButton;
    private JLabel idBlank;
    private JTextField idLBL;
    private JTextField blankType2;
    private JLabel blankTypeLBL;
    private JTextField blankQty;
    private JLabel quantity;
    private JDatePicker date;

    public GUISAAddNewBlank(JFrame parent) {

        super(parent);
        setTitle("Add New Blank");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,700 ));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUISAAccessBlankStock(null).setVisible(false);
                panel1.setVisible(false);
            }

        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idLBL.getText().equals("") ||blankQty.getText().equals("") || blankType2.getText().equals("")) {
                    error();
                } else {
                    String data [] = {idLBL.getText(), blankQty.getText(),blankType2.getText()};
                }}
        });

        setVisible(true);





    }

    private void error(){
        JOptionPane.showMessageDialog(this, "Please enter all data");
    }

    public static void main(String[] args) {
        GUISAAddNewBlank panel = new GUISAAddNewBlank(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}