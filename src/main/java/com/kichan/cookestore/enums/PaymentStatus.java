package com.kichan.cookestore.enums;

public enum PaymentStatus {
    PROCESSING("PROCESSING"),COMPLETED("COMPLETED"),DECLINED("DECLINED"),ORDER_CHANGED("ORDER CHANGED"),CANCELLED("CANCELLED"),PENDING("PENDING");
    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
