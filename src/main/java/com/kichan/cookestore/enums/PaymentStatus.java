package com.kichan.cookestore.enums;

public enum PaymentStatus {
    PROCESSING("PROCESSING"),ACCEPTED("ACCEPTED"),DECLINED("DECLINED"),ORDER_CHANGED("ORDER CHANGED"),CANCELLED("CANCELLED");
    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
