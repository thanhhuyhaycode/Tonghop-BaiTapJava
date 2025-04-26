package bai1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeFrame extends JFrame{
	public HomeFrame(String username) {
        setTitle("Welcome");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome, " + username);
        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(e -> {
            new LoginFrame();
            this.dispose(); // Đóng cửa sổ hiện tại
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(logoutButton);

        add(panel);
        setVisible(true);
    }

}
