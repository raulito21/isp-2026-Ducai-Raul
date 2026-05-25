package isp.lab5.exercise1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

/**
 * @author Radu Miron
 * @version 1
 */
public class Exercise1Test {

    @Test
    public void testOrderTotalPriceCalculation() {
        // Arrang: pregătim datele de test
        Address addr = new Address("Test Street", "Test City");
        Customer testCustomer = new Customer("1", "John Doe", "0000", addr);
        Order order = new Order("O-1", LocalDateTime.now(), testCustomer);

        Product p1 = new Product("1", "Item A", 10.5, ProductCategory.BEAUTY);
        Product p2 = new Product("2", "Item B", 20.0, ProductCategory.HOME_AND_GARDEN);

        order.addProduct(p1);
        order.addProduct(p2);

        assertEquals(30.5, order.getTotalPrice(), 0.001,
                "Prețul total al comenzii ar trebui să fie suma prețurilor produselor adăugate.");
    }
}