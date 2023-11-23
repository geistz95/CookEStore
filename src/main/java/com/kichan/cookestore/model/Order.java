package com.kichan.cookestore.model;

import javax.persistence.*;

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

    public Order(Long id, Long customerName, Customer customer) {
        this.id = id;
        this.customerName = customerName;
        this.customer = customer;
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
}
