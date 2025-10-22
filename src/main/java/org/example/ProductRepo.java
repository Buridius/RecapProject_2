package org.example;

import java.util.ArrayList;

public class ProductRepo {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public Product getProduct(int id){
        for (Product product : products){
            if( product.id() == id){
                return product;
            }
        }
        return null;
    }
}
