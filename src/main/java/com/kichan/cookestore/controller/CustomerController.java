package com.kichan.cookestore.controller;

import com.kichan.cookestore.model.Customer;
import com.kichan.cookestore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer created = customerService.createCustomer(customer);
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        return new ResponseEntity<>(created, HttpStatus.CREATED);

}

    @PutMapping("/customers/{customer_id}")
    public ResponseEntity<?> editCustomer(@PathVariable Long customer_id, @RequestBody Customer customer){
        Customer editted =customerService.editCustomer(customer_id,customer);
        return new ResponseEntity<>(editted, HttpStatus.OK);
    }


    @GetMapping("/customers/{customer_id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customer_id){
        return new ResponseEntity<>(customerService.getById(customer_id), HttpStatus.OK);
    }


    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }


    @DeleteMapping("/customers/{customer_id}")
    public ResponseEntity<?> getDeleteCustomer(@PathVariable Long customer_id){
        customerService.deleteCustomer(customer_id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

}
