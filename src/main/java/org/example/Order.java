package org.example;

import lombok.With;

import java.time.LocalDateTime;

@With
public record Order(String id, String customerName, Product product, int amount, String status, LocalDateTime createdAt) {

}
