package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin extends JDialog {
    private JPanel mainPanel;
    private JPasswordField tfPassword;
    private JTextField tfEmail;
    private JTextField tfuserName;
    private JButton btnLogin;
    private JPasswordField tfpassWord;


    public GUILogin(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(450, 274));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = tfuserName.getText();
                String passWord = String.valueOf(tfpassWord.getPassword());
            }
        });
    }

    public static void main(String[] args) {
        GUILogin login = new GUILogin(null);
    }
}