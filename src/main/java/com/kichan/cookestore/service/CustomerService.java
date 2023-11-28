package com.kichan.cookestore.service;

import com.kichan.cookestore.exceptions.CustomerNotFoundException;
import com.kichan.cookestore.model.Customer;
import com.kichan.cookestore.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(BillService.class);
    public Customer verifyCustomer(Long id){
        logger.info("Verifying customer id  " +id);
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            logger.error("Customer id " + id + " was not found");
            throw new CustomerNotFoundException("");
        }
        return customer.get();
    }

    public void createCustomer(Customer customer){
        logger.info("Saving customer to repository");
        customerRepository.save(customer);
    }

    public void editCustomer(Long customer_id,Customer customer){
        Customer editCustomer = verifyCustomer(customer_id);
        editCustomer.setAddress(customer.getAddress());
        editCustomer.setfName(customer.getfName());
        editCustomer.setlName(customer.getlName());
        logger.info("Editing customer successful");
        customerRepository.save(editCustomer);
    }

    public void deleteCustomer(Long customer_id){
        logger.info("Deleting customer id "+ customer_id);
        customerRepository.delete(verifyCustomer(customer_id));
    }
}
