package org.example;

import java.util.ArrayList;

public class OrderListRepo {
    ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders(){
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
