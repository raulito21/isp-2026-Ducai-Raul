package isp.lab5.exercise1;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private Address address; // Relația către Address (multiplicitate 1)

    public Customer(String customerId, String name, String phone, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public Address getAddress() { return address; }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}