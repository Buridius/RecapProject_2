package org.example;

import java.util.UUID;

public class UuidGenerator {

    public static  String generateId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
