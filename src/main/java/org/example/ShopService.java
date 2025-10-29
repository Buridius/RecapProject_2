package org.example;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class ShopService {

    OrderRepo orderRepo;
    ProductRepo productRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(String customerName, Product product, int amount) {
        try {
            for( int i = 0; i < productRepo.getProducts().size(); i++ ) {
                if (!(productRepo.getProducts().contains(product))) {
                    throw new Exception("Product not found");
                }
            }
        }catch (Exception ex){
            System.out.println("No product found");
        }
        try {
            Order newOrder = new Order(Utilities.generateId(), customerName, product, amount, "PROCESSING", ZonedDateTime.now());
            orderRepo.addOrder(newOrder);
        } catch (Exception ex) {
            System.out.println("Product not found");
        }
    }

    public ArrayList getOrderByStatus(String status) {
        ArrayList<Order> returnValue = new ArrayList<>();
        orderRepo.getArrayOrders().stream()
                .filter(s -> s.status().equals(status))
                .forEach(o -> returnValue.add(o) );

        return returnValue;
    }

    public void updateOrder(String id) {
        Order order = orderRepo.getOrder(id);

        if (order.id().equals(id)){
            if (order.status().equals(Utilities.orderStatus.PROCESSING.getDisplayName())) {
                order.withStatus(Utilities.orderStatus.IN_DELIVERY.getDisplayName());
            } else if (order.status().equals(Utilities.orderStatus.IN_DELIVERY.getDisplayName())) {
                    order.withStatus(Utilities.orderStatus.COMPLETED.getDisplayName());
            }

        }

    }
}
