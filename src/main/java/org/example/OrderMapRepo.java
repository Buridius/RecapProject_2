package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderMapRepo implements OrderRepo {
    HashMap<Integer, Order> orders = new HashMap<>();

    @Override
    public HashMap<Integer, Order> getMapOrders(){
        return orders;
    }

    @Override
    public ArrayList<Order> getArrayOrders() {
        return null;
    }

    public void addOrder(Order order){
        orders.put(order.id(), order);
    }
    public void removeOrder(Order order){
        orders.remove(order.id(), order);
    }
    public Order getOrder(int id){
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        System.out.println("Order not found");
        return null;
    }
}
