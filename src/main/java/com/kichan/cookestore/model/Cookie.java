package com.kichan.cookestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Cookie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cookie_id;

    @Column(name = "cookie_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

    public Cookie(Long cookie_id, String name, String description, Double price, Integer quantity, Order order) {
        this.cookie_id = cookie_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}