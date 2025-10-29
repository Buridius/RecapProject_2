package org.example;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        OrderListRepo orderListRepo = new OrderListRepo();

        Product product1 = new Product(1, "item1", 4.29);
        Product product2 = new Product(2, "item2", 5.79);
        Product product3 = new Product(3, "item3", 17.19);
        Product product4 = new Product(4, "item4", 9.39);
        Product product5 = new Product(5, "item5", 11.99);
        Product product6 = new Product(6, "Arcades", 19.99);

        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        productRepo.addProduct(product3);
        productRepo.addProduct(product4);
        productRepo.addProduct(product5);


        Order order1 = new Order(UuidGenerator.generateId(), "Customer1",product1 ,3, "PROCESSING", ZonedDateTime.now() );
        Order order2 = new Order(UuidGenerator.generateId(), "Customer2",product2 ,7, "PROCESSING", ZonedDateTime.now() );
        Order order3 = new Order(UuidGenerator.generateId(), "Customer3",product3 ,5, "PROCESSING", ZonedDateTime.now() );
        Order noProduct = new Order(UuidGenerator.generateId(), "Customer3",product6 ,7, "PROCESSING", ZonedDateTime.now() );

        orderListRepo.addOrder(order1);
        orderListRepo.addOrder(order2);
        orderListRepo.addOrder(order3);
        orderListRepo.addOrder(noProduct);

        ShopService shopService = new ShopService(productRepo, orderListRepo);
        shopService.placeOrder( "Customer5", product3, 5);
    }
}