package com.kichan.cookestore.service;

import com.kichan.cookestore.repository.BillRepository;
import com.kichan.cookestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private OrderRepository orderRepository;


}
