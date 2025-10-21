package org.example;

import java.util.ArrayList;

public interface OrderRepo {

    ArrayList<Order> getOrders();
    void addOrder(Order order);
    void removeOrder(Order order);
    Order getOrder(int id);
}
