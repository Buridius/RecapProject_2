package org.example;

public record Order(int id, String customerName, Product product, int amount) {
}
