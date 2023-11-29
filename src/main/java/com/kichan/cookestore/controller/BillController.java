package com.kichan.cookestore.controller;

import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.repository.BillRepository;
import com.kichan.cookestore.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.kichan.cookestore.response.BillResponse.*;

@RestController
public class BillController {

    @Autowired
    private BillService billService;
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    @GetMapping("/bills/{bill_id}")
    public ResponseEntity<?> getBill(@PathVariable Long bill_id){
        logger.info("Getting bill at "+ bill_id);

        //return custom response
        return getBillResponse(HttpStatus.OK,billService.getById(bill_id));
    }

    @GetMapping("/customer/{customer_id}/bills")
    public ResponseEntity<?> getAllUnpaidBillsByCustomerID(@PathVariable Long customerID){
        logger.info("Getting all customers for customer id : "+customerID);

        //return custom response
        return getAllBilLsByCustomerIDResponse(HttpStatus.OK,billService.unpaidBills(customerID));
    }

    @PutMapping("/bills/{bill_id}")
    public ResponseEntity<?> payBill(@PathVariable Long bill_id){
        return new ResponseEntity<>(billService.payBill(bill_id),HttpStatus.OK);
    }

}
