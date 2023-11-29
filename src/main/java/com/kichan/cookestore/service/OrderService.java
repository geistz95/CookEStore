package com.kichan.cookestore.service;

import com.kichan.cookestore.enums.OrderStatus;
import com.kichan.cookestore.enums.PaymentStatus;
import com.kichan.cookestore.exceptions.OrderNotFoundException;
import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.model.Customer;
import com.kichan.cookestore.model.Order;
import com.kichan.cookestore.repository.BillRepository;
import com.kichan.cookestore.repository.CustomerRepository;
import com.kichan.cookestore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionalService transactionalService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillService billService;

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    public Order verifyOrder(Long id){
        Optional<Order> o = orderRepository.findById(id);
        if(o.isEmpty()){
            logger.error("Order hasn't been found "+ id);
            throw new OrderNotFoundException("Order with id + "+ id + " not found");
        }
        return o.get();
    }

    public Order createOrder(Order order) {
        logger.info("Adding new order to order repository");
        order.setStatus(OrderStatus.PENDING);

        // Create and save the Bill entity separately

        Customer customer = customerService.getById(order.getCustomerID());
        order.setCustomerName(customer.getfName() + " " + customer.getlName());
        order.setCustomer(customer);
        Bill bill = transactionalService.calculateOrderTotalToBill(order);
        billRepository.save(bill);
        // Associate the created bill with the order
        logger.info("Attempting to save");
        order.setBill(bill);
        logger.info("bill has been saved!");

        // Now, save the order



        orderRepository.save(order);
        logger.info("order saved!");
        return order;
    }

    public Order getOrder(Long id){
        logger.info("Getting order id "+id);
        return verifyOrder(id);
    }

    public void editOrder(Long id, Order order){
        Order oldOrder= verifyOrder(id);
        //Logic here is that only the list of cookies is being changed
        logger.info("Editting order info for id "+id);
        oldOrder.setCookies(order.getCookies());
        transactionalService.calculateNewBill(oldOrder);

    }

    public void cancelOrder(Long id){
        Order orderToCancel = verifyOrder(id);
        orderToCancel.getBill().setStatus(PaymentStatus.CANCELLED);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }


}
