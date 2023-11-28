package com.kichan.cookestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name="customer_name")
    private Long customerName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("order")
    private List<Cookie> cookies;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="bill_id")
    private Bill bill;

    public Order(Long id, Long customerName, Customer customer, List<Cookie> cookies, Bill bill) {
        this.id = id;
        this.customerName = customerName;
        this.customer = customer;
        this.cookies = cookies;
        this.bill = bill;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Long customerName) {
        this.customerName = customerName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Cookie> getCookies() {
        return cookies;
    }

    public void setCookies(List<Cookie> cookies) {
        this.cookies = cookies;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
