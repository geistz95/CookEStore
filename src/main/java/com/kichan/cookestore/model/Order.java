package com.kichan.cookestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kichan.cookestore.enums.OrderStatus;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cookieorders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name="customer_name")
    private String customerName;


    @Enumerated(EnumType.STRING)
    @Column(name="order_status")
    private OrderStatus status;

    @Column(name = "getCustomer")
    @NotNull
    private Long customerID;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name="order_id")
    @JsonIgnoreProperties("order")
    private List<Cookie> cookies;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "bill_id")
    private Bill bill;



    public Order() {
    }

    public Order(Long id, String customerName, OrderStatus status, Long customerID, Customer customer, List<Cookie> cookies, Bill bill) {
        this.id = id;
        this.customerName = customerName;
        this.status = status;
        this.customerID = customerID;
        this.customer = customer;
        this.cookies = cookies;
        this.bill = bill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }
}
