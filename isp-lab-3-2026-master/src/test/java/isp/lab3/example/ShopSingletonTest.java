package isp.lab3.example;

public class ShopSingleton {

    private static ShopSingleton instance;

    private ShopSingleton() {
    }

    public static ShopSingleton getInstance() {
        if (instance == null) {
            instance = new ShopSingleton();
        }
        return instance;
    }
}