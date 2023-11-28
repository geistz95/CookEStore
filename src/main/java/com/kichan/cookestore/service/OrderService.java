package com.kichan.cookestore.service;

import com.kichan.cookestore.enums.PaymentStatus;
import com.kichan.cookestore.exceptions.OrderNotFoundException;
import com.kichan.cookestore.model.Order;
import com.kichan.cookestore.repository.CustomerRepository;
import com.kichan.cookestore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired TransactionalService transactionalService;

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    public Order verifyOrder(Long id){
        Optional<Order> o = orderRepository.findById(id);
        if(o.isEmpty()){
            logger.error("Order hasn't been found "+ id);
            throw new OrderNotFoundException("Order with id + "+ id + " not found");
        }
        return o.get();
    }

    public void createOrder(Order order){
        logger.info("Adding new order to order repository");
        orderRepository.save(order);
    }

    public Order getOrder(Long id){
        logger.info("Getting order id "+id);
        return verifyOrder(id);
    }

    public void editOrder(Long id, Order order){
        Order oldOrder= verifyOrder(id);
        //Logic here is that only the list of cookies is being changed
        logger.info("Editting info ");
        oldOrder.setCookies(order.getCookies());

    }

    public void cancelOrder(Long id){
        Order orderToCancel = verifyOrder(id);
        orderToCancel.getBill().setStatus(PaymentStatus.CANCELLED);
    }


}
