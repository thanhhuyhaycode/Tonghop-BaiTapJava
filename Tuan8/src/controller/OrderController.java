package controller;
import model.OrderItem;
import model.Order;
import dao.OrderDAO;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class OrderController {
    private OrderDAO orderDAO = new OrderDAO();  // Khai báo instance của OrderDAO

    public void createOrder(int customerId, List<model.OrderItem> items) {
        try {
            Order order = new Order(0, customerId, new java.util.Date(), items);
            orderDAO.addOrder(order);
            JOptionPane.showMessageDialog(null, "Đơn hàng đã được thêm thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm đơn hàng: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ✅ Phương thức showOrderHistory đã sửa lỗi
    public void showOrderHistory(int customerId) {
        try {
            List<Order> orders = orderDAO.getOrderHistory(customerId);
            StringBuilder history = new StringBuilder("Lịch sử đơn hàng:\n");

            if (orders.isEmpty()) {
                history.append("Không có đơn hàng nào.");
            } else {
                for (Order order : orders) {
                    history.append("ID: ").append(order.getId())
                           .append(", Ngày: ").append(order.getOrderDate())
                           .append("\n");
                }
            }

            JOptionPane.showMessageDialog(null, history.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy lịch sử đơn hàng: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
