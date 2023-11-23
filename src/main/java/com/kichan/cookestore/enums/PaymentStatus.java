package com.kichan.cookestore.enums;

public enum PaymentStatus {
    PROCESSING("PROCESSING"),ACCEPTED("ACCEPTED"),DECLINED("DECLINED");
    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
