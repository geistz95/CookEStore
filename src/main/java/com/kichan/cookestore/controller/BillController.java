package com.kichan.cookestore.controller;

import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.repository.BillRepository;
import com.kichan.cookestore.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/bills/{bill_id}")
    public ResponseEntity<?> getBill(@PathVariable Long bill_id){
        billService.getById(bill_id);
    }

    @PutMapping("/bills/{bill_id}")
    public ResponseEntity<?> editBill(@PathVariable Long bill_id, @RequestBody Bill bill){
        billService.editBill(bill_id, bill);
    }

    @DeleteMapping("/bills/{bill_id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long bill_id){
        billService.deleteByBillId(bill_id);
    }

    @GetMapping("/customer/{customer_id}/bills")
    public ResponseEntity getAllUnpaidBillsByCustomerID(@PathVariable Long customerID){
        billService.unpaidBills(customerID);
    }

}
