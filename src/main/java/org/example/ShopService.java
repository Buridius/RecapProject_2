package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopService {

    OrderRepo orderRepo;
    ProductRepo productRepo;
    static int orderId = 0;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(String customerName, Product product, int amount) {
        if (productRepo.getProduct(product.id()) != null) {
            orderId++;
            Order newOrder = new Order(orderId, customerName, product, amount );
            orderRepo.addOrder(newOrder);
        } else {
            System.out.println("Product not found");
        }
    }
}
