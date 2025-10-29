package org.example;

import lombok.With;

@With
public record Order(String id, String customerName, Product product, int amount, String status, java.time.ZonedDateTime createdAt) {

}
