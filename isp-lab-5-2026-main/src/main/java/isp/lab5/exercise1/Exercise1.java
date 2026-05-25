package isp.lab5.exercise1;

import java.time.LocalDateTime;

public class Exercise1 {

    public static void main(String[] args) {
        Address address = new Address("Strada Observatorului 34", "Cluj-Napoca");
        Customer customer = new Customer("C001", "Radu Miron", "0700123456", address);

        Product p1 = new Product("P001", "Laptop Dell", 4500.50, ProductCategory.ELECTRONICS);
        Product p2 = new Product("P002", "Tricou Polo", 150.00, ProductCategory.FASHION);
        Product p3 = new Product("P003", "Lego Star Wars", 350.00, ProductCategory.TOYS);

        Order order = new Order("ORD-9981", LocalDateTime.now(), customer);

        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p3);

        System.out.println("=== Detalii Client ===");
        System.out.println(customer.toString());

        System.out.println("\n=== Detalii Comandă ===");
        System.out.println(order.toString());

        System.out.println("\nProduse comandate:");
        for (Product prod : order.getProducts()) {
            if (prod != null) {
                System.out.println(" - " + prod.toString());
            }
        }
    }
}