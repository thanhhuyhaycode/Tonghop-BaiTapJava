package model;
import model.OrderItem;
import java.util.*;

public class Order {
    private int id;
    private int customerId;
    private Date orderDate;
    private List<OrderItem> items;

    public Order(int id, int customerId, Date orderDate, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
    }
    
    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public Date getOrderDate() { return orderDate; }
    public List<OrderItem> getItems() { return items; }
}