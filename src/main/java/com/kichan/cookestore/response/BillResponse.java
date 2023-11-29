package com.kichan.cookestore.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BillResponse {

    public static ResponseEntity<Object> getBillResponse(HttpStatus httpStatus, Object responseObject){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Successfully got bill");
        response.put("data", responseObject);
        response.put("HttpStatus Code", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<Object> getAllBilLsByCustomerIDResponse(HttpStatus httpStatus, Object responseObject){
        Map<String,Object> response = new HashMap<>();
        response.put("message","bills for customer");
        response.put("data", responseObject);
        response.put("HttpStatus Code", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }

}
