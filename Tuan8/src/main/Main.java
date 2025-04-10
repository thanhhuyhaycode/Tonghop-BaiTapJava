package main;

import javax.swing.*;

import controller.OrderController;
import model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng OrderController
        OrderController orderController = new OrderController();

        // Nhập thông tin khách hàng
        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Nhập ID khách hàng:"));

        // Tạo danh sách các OrderItem (mặt hàng trong đơn hàng)
        List<OrderItem> items = new ArrayList<>();

        // Tạo đơn hàng mới
        orderController.createOrder(customerId, items);

        // Hiển thị lịch sử đơn hàng
        orderController.showOrderHistory(customerId);
    }
}
