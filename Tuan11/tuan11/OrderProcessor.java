package tuan11;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderProcessor {

    public static void main(String[] args) {
        List<Customer> customers = createSampleCustomers();
        List<Product> products = createSampleProducts();
        List<Order> orders = createSampleOrders(customers, products);

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        List<Product> discountedProducts = processOrders(orders, startDate, endDate);

        System.out.println("\nDanh sách sản phẩm đã được giảm giá:");
        discountedProducts.forEach(p -> System.out.println(
                p.getName() + " - " + p.getCategory() + " - Giá: " + p.getPrice()
        ));
    }

    public static List<Product> processOrders(List<Order> orders, LocalDate startDate, LocalDate endDate) {
        return orders.stream()
                .filter(order -> order.getCustomer().getMoney() == 2)
                .filter(order -> !order.getOrderDate().isBefore(startDate) && !order.getOrderDate().isAfter(endDate))
                .peek(order -> System.out.println("Xử lý đơn hàng: " + order.getOrderDate()
                        + " - Trạng thái: " + order.getStatus()))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .map(product -> {
                    if ("Toys".equalsIgnoreCase(product.getCategory())) {
                        Product discounted = new Product(
                                product.getName(),
                                product.getCategory(),
                                product.getPrice() * 0.9
                        );
                        return discounted;
                    }
                    return product;
                })
                .filter(product -> "Toys".equalsIgnoreCase(product.getCategory()))
                .collect(Collectors.toList());
    }

    private static List<Customer> createSampleCustomers() {
        return Arrays.asList(
                new Customer(1, 2), // money = 2
                new Customer(2, 3),
                new Customer(3, 2)  // money = 2
        );
    }

    private static List<Product> createSampleProducts() {
        return Arrays.asList(
                new Product("Xe hơi đồ chơi", "Toys", 100),
                new Product("Búp bê", "Toys", 50),
                new Product("Điện thoại", "Electronics", 500),
                new Product("Laptop", "Electronics", 1000),
                new Product("Lego", "Toys", 80)
        );
    }

    private static List<Order> createSampleOrders(List<Customer> customers, List<Product> products) {
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order(
                LocalDate.of(2021, 2, 15),
                LocalDate.of(2021, 2, 20),
                "Delivered",
                customers.get(0)
        );
        order1.setProducts(Arrays.asList(products.get(0), products.get(2)));
        orders.add(order1);

        Order order2 = new Order(
                LocalDate.of(2021, 3, 10),
                LocalDate.of(2021, 3, 15),
                "Shipped",
                customers.get(2)
        );
        order2.setProducts(Arrays.asList(products.get(1), products.get(4)));
        orders.add(order2);

        Order order3 = new Order(
                LocalDate.of(2021, 3, 20),
                LocalDate.of(2021, 3, 25),
                "Processing",
                customers.get(1)
        );
        order3.setProducts(Arrays.asList(products.get(3)));
        orders.add(order3);

        return orders;
    }
}

class Customer {
    private int id;
    private int money;

    public Customer(int id, int money) {
        this.id = id;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}

class Order {
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private Customer customer;
    private List<Product> products;

    public Order(LocalDate orderDate, LocalDate deliveryDate, String status, Customer customer) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }
}
