package dao;

import model.Order;
import model.OrderItem;
import java.sql.*;
import java.util.*;

public class OrderDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/order_management";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addOrder(Order order) throws SQLException {
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            String orderQuery = "INSERT INTO orders (customer_id, order_date) VALUES (?, NOW())";
            PreparedStatement orderStmt = conn.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setInt(1, order.getCustomerId());
            orderStmt.executeUpdate();
            ResultSet rs = orderStmt.getGeneratedKeys();
            rs.next();
            int orderId = rs.getInt(1);
            
            String orderItemQuery = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement orderItemStmt = conn.prepareStatement(orderItemQuery);
            for (OrderItem item : order.getItems()) {
                orderItemStmt.setInt(1, orderId);
                orderItemStmt.setInt(2, item.getProductId());
                orderItemStmt.setInt(3, item.getQuantity());
                orderItemStmt.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.close();
        }
    }
    
    public List<Order> getOrderHistory(int customerId) throws SQLException {
        Connection conn = getConnection();
        List<Order> orders = new ArrayList<>();
        String query = "SELECT id, order_date FROM orders WHERE customer_id = ? ORDER BY order_date DESC";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            orders.add(new Order(rs.getInt("id"), customerId, rs.getDate("order_date"), new ArrayList<>()));
        }
        conn.close();
        return orders;
    }
    
    public double calculateTotalOrder(int orderId) throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT SUM(p.price * oi.quantity) AS total FROM order_items oi JOIN products p ON oi.product_id = p.id WHERE oi.order_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, orderId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("total");
        }
        conn.close();
        return 0;
    }
}