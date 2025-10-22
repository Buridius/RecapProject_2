package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderRepo {

    HashMap<Integer, Order> getMapOrders();
    ArrayList<Order> getArrayOrders();
    void addOrder(Order order);
    void removeOrder(Order order);

    default Order getOrder(int id) {
        return null;
    }
}
