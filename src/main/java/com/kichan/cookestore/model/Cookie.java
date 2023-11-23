package com.kichan.cookestore.model;

import javax.persistence.*;

@Entity
public class Cookie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cookie_id;

    @Column(name="cookie_name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;


    public Cookie(Long cookie_id, String name, String description, Bill bill) {
        this.cookie_id = cookie_id;
        this.name = name;
        this.description = description;
        this.bill = bill;
    }

    public Cookie() {
    }

    public Long getCookie_id() {
        return cookie_id;
    }

    public void setCookie_id(Long cookie_id) {
        this.cookie_id = cookie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
