package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;

    private Customer customer;
    private Product[] products;
    private int productCount;
    public Order(String orderId, LocalDateTime date, Customer customer) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
        this.products = new Product[10];
        this.totalPrice = 0.0;
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < 10) {
            this.products[productCount] = product;
            this.totalPrice += product.getPrice();
            productCount++;
        } else {
            System.out.println("Comanda a atins limita maximă de 10 produse!");
        }
    }

    public String getOrderId() { return orderId; }
    public LocalDateTime getDate() { return date; }
    public double getTotalPrice() { return totalPrice; }
    public Customer getCustomer() { return customer; }
    public Product[] getProducts() { return products; }

    @Override
    public String toString() {
        return "Order " + orderId + " | Client: " + customer.getName() + " | Total: " + totalPrice + " RON";
    }
}