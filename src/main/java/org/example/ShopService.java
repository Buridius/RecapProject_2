package org.example;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RequiredArgsConstructor
public class ShopService {

    OrderRepo orderRepo;
    ProductRepo productRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(String customerName, Product product, int amount) {
        try {
            Order newOrder = new Order(UuidGenerator.generateId(), customerName, product, amount, "PROCESSING", LocalDateTime.now());
            orderRepo.addOrder(newOrder);
        } catch (Exception ex) {
            System.out.println("Product not found");
        }
    }

    public ArrayList getOrderByStatus(String status) {
        ArrayList returnValue = new ArrayList<Order>();
        orderRepo.getArrayOrders().stream()
                .filter(s -> s.status().equals(status))
                .forEach(o -> returnValue.add(o) );

        return returnValue;
    }

    public void updateOrder(String id) {
        for (int i = 0; i < orderRepo.getArrayOrders().size(); i++) {
            Order order = orderRepo.getArrayOrders().get(i);
            if (order.id().equals(id)){
                if (order.status().equals("PROCESSING")) {
                    order.withStatus("IN_DELIVERY");
                } else if (order.status().equals("IN_DELIVERY")) {
                    order.withStatus("COMPLETED");
                }

            }
        }
    }
}
