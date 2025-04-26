package bai1;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    // Giả lập database (tên người dùng -> mật khẩu đã mã hóa SHA)
    private HashMap<String, String> userDB = new HashMap<>();

    public LoginFrame() {
        setTitle("Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Sample user
        try {
            userDB.put("admin", PasswordUtil.hashSHA("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        messageLabel = new JLabel("");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel(""));
        add(loginButton);
        add(messageLabel);

        loginButton.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        try {
            String hashed = PasswordUtil.hashSHA(pass);
            if (userDB.containsKey(user) && userDB.get(user).equals(hashed)) {
                JOptionPane.showMessageDialog(this, "Login success!");
                new HomeFrame(user);
                this.dispose(); // đóng cửa sổ login
            } else {
                messageLabel.setText("Invalid username or password");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
