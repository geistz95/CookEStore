package com.kichan.cookestore.controller;

import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.repository.BillRepository;
import com.kichan.cookestore.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    @Autowired
    private BillService billService;
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    @GetMapping("/bills/{bill_id}")
    public ResponseEntity<?> getBill(@PathVariable Long bill_id){
        logger.info("Getting bill at "+ bill_id);
        billService.getById(bill_id);
        //return custom response
    }

    @DeleteMapping("/bills/{bill_id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long bill_id){
        billService.deleteByBillId(bill_id);
        //return custom response
    }

    @GetMapping("/customer/{customer_id}/bills")
    public ResponseEntity getAllUnpaidBillsByCustomerID(@PathVariable Long customerID){
        billService.unpaidBills(customerID);
        //return custom response
    }

}
