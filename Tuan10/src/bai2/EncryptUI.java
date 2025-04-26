package bai2;
import javax.swing.*;
import java.awt.*;

public class EncryptUI extends JFrame {
    private JTextField inputField;
    private JComboBox<String> algoBox;
    private JTextArea resultArea;
    private JButton encryptBtn, decryptBtn;

    private Encryptable encryptor;

    public EncryptUI() {
        setTitle("Mã hóa chuỗi");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputField = new JTextField();
        algoBox = new JComboBox<>(new String[]{"AES", "RSA"});
        resultArea = new JTextArea(5, 30);
        resultArea.setLineWrap(true);
        encryptBtn = new JButton("Mã hóa");
        decryptBtn = new JButton("Giải mã");

        topPanel.add(new JLabel("Nhập chuỗi:"));
        topPanel.add(inputField);
        topPanel.add(new JLabel("Thuật toán:"));
        topPanel.add(algoBox);
        topPanel.add(encryptBtn);
        topPanel.add(decryptBtn);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        encryptBtn.addActionListener(e -> handleEncrypt());
        decryptBtn.addActionListener(e -> handleDecrypt());

        setVisible(true);
    }

    private void setEncryptor() {
        try {
            String selected = algoBox.getSelectedItem().toString();
            if (selected.equals("AES")) {
                encryptor = new AESEncryption();
            } else if (selected.equals("RSA")) {
                encryptor = new RSAEncryption();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleEncrypt() {
        try {
            setEncryptor();
            String input = inputField.getText();
            String encrypted = encryptor.encrypt(input);
            resultArea.setText(encrypted);
        } catch (Exception e) {
            resultArea.setText("Lỗi mã hóa: " + e.getMessage());
        }
    }

    private void handleDecrypt() {
        try {
            setEncryptor();
            String encrypted = resultArea.getText();
            String decrypted = encryptor.decrypt(encrypted);
            resultArea.setText(decrypted);
        } catch (Exception e) {
            resultArea.setText("Lỗi giải mã: " + e.getMessage());
        }
    }
}