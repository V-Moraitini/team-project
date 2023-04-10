package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOfficeManager extends JDialog {
    private JPanel mainPanel;
    private JButton domRepBtn;
    private JButton BtnSeDisPlan;
    private JButton btnAccessBStock;
    private JButton btnAssBStock;
    private JButton btnLogOut;
    private JButton intRepBtn;


    public GUIOfficeManager(JFrame parent) {

        super(parent);
        setTitle("Office Manager");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                setVisible(false);
            }
        });


        domRepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOMGlobalReport(null).setVisible(false);
                setVisible(false);
            }
        });
        BtnSeDisPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOMSetDiscountPlan(null).setVisible(false);
                setVisible(false);
            }
        });
        btnAccessBStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOMAccessBlankStock(null).setVisible(false);
                setVisible(false);
            }
        });
        btnAssBStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOMAssignBlankStock(null).setVisible(false);
                setVisible(false);
            }
        });

        intRepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUIOMInterlineReports(null).setVisible(false);
                setVisible(false);
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        GUIOfficeManager panel = new GUIOfficeManager(null);
    }
}
