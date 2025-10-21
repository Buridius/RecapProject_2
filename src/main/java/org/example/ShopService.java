package org.example;

public class ShopService {

    public void placeOrder(ProductRepo productRepo, Product product, Order order) {
        if (!productRepo.getProduct(product.id()) ) {
            System.out.println("Product not found");
        } else {

        }


    }
}
