package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderListRepo implements OrderRepo {
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public HashMap<Integer, Order> getMapOrders() {
        return null;
    }

    @Override
    public ArrayList<Order> getArrayOrders() {
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }
    public void removeOrder(Order order){
        orders.remove(order);
    }
    public Order getOrder(int id){
        for (Order order : orders) {
            if (order.id() == id) {
                return order;
            }
        }
        System.out.println("Order not found");
        return null;
    }
}
