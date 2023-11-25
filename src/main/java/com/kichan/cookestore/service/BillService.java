package com.kichan.cookestore.service;

import com.kichan.cookestore.exceptions.BillNotFoundException;
import com.kichan.cookestore.exceptions.OrderNotFoundException;
import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.model.Order;
import com.kichan.cookestore.repository.BillRepository;
import com.kichan.cookestore.repository.CustomerRepository;
import com.kichan.cookestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);
    private Bill verifyID(Long billId){
        Optional<Bill> b = billRepository.findById(billId);
        if(b.isEmpty()){
            logger.error("The bill id cannot be found  | ID : "+billId);
            throw new BillNotFoundException("Bill id "+ billId + " Not found");
        }
        return b.get();
    }

    private Order verifyOrder(Long orderId){
        Optional<Order> o = orderRepository.findById(orderId);
        if(o.isEmpty()){
            logger.error("The order id cannot be found | ID : "+orderId );
            throw new OrderNotFoundException("Order id " + orderId + " Not Found");
        }
        return o.get();
    }
    private Order verifyCustomer(Long customerId){
        Optional<Order> o = orderRepository.findById(customerId);
        if(o.isEmpty()){
            logger.error("The customer id cannot be found | ID : "+customerId );
            throw new OrderNotFoundException("Customer id " + customerId + " Not Found");
        }
        return o.get();
    }



    public void createBill(Long orderId, Bill bill){
        logger.info("Order is being verified");
        verifyOrder(orderId);
        logger.info("Order verification successful");
        billRepository.save(bill);
    }

    public void editBill(Long billId, Bill bill){
        logger.info("Bill is being verified");
        Bill oldBill = verifyID(billId);
        logger.info("Bill verification has been successful");
        oldBill.setOrder(bill.getOrder());
        oldBill.setStatus(bill.getStatus());
        oldBill.setTotal(bill.getTotal());
        oldBill.setCustomer_name(bill.getCustomer_name());
        billRepository.save(oldBill);
    }

    public void deleteByBillId(Long billId) {
        logger.info("Verifying and deleting the bill id " + billId);
        billRepository.delete(verifyID(billId));
    }

    public Bill getById(Long billId) {
        logger.info("Verifying and getting the bill id " + billId);
        return verifyID(billId);
    }

    public Iterable<Bill> unpaidBills(Long customerID) {
        logger.info("Verifying and getting the bills that are unpaid for customer id  " + customerID);
        verifyCustomer(customerID);
        return billRepository.unpaidBills(customerID);
    }
}
