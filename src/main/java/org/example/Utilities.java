package org.example;

import java.util.UUID;

public class Utilities {

    public static  String generateId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public enum orderStatus {
        PROCESSING("PROCESSING"),
        IN_DELIVERY("IN_DELIVERY"),
        COMPLETED("COMPLETED");

        private String displayName;

        void OrderStatus(String displayName) {
            this.displayName = displayName;
        }

        orderStatus(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
