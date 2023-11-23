package com.kichan.cookestore.service;

import com.kichan.cookestore.repository.CustomerRepository;
import com.kichan.cookestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;
}
