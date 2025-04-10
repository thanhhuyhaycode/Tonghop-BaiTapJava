package view;
import controller.OrderController;
import java.util.List;
import model.OrderItem;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class OrderManagementApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Order Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(3, 1));
        
        JButton addOrderButton = new JButton("Thêm đơn hàng");
        JButton viewHistoryButton = new JButton("Xem lịch sử đơn hàng");
        JButton calculateTotalButton = new JButton("Tính tổng tiền đơn hàng");
        
        panel.add(addOrderButton);
        panel.add(viewHistoryButton);
        panel.add(calculateTotalButton);
        
        OrderController orderController = new OrderController();
        
        addOrderButton.addActionListener(e -> {
            List<OrderItem> items = Arrays.asList(new OrderItem(1, 2), new OrderItem(2, 1));
            orderController.createOrder(1, items);
        });
        
        viewHistoryButton.addActionListener(e -> orderController.showOrderHistory(1));
        
        calculateTotalButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Chức năng tính tổng tiền chưa triển khai!"));
        
        frame.setVisible(true);
    }
}
