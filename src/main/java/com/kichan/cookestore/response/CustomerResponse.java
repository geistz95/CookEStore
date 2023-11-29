package com.kichan.cookestore.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CustomerResponse {

    public static ResponseEntity<Object> getCustomerResponse(HttpStatus httpStatus, Object responseObject){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Successfully got Customer");
        response.put("data", responseObject);
        response.put("HttpStatus Code", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }
}
