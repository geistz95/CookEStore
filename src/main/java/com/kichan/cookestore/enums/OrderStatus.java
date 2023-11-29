package com.kichan.cookestore.enums;

public enum OrderStatus {
    PENDING("PENDING"),COMPLETED("COMPLETED"),CANCELLED("CANCELLED"),PAID("PAID"),REFUNDED("REFUNDED");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
