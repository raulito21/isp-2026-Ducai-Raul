package isp.lab5.exercise1;

public class Product {
    private String productId;
    private String name;
    private double price;
    private ProductCategory productCategory;

    public Product(String productId, String name, double price, ProductCategory productCategory) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public ProductCategory getProductCategory() { return productCategory; }

    @Override
    public String toString() {
        return name + " (" + productCategory + ") - " + price + " RON";
    }
}