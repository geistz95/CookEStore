package com.kichan.cookestore.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class OrderResponse {

    public static ResponseEntity<Object> getOrderResponse(HttpStatus httpStatus, Object responseObject){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Successfully got Order");
        response.put("data", responseObject);
        response.put("HttpStatus Code", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<Object> createOrderResponse(HttpStatus httpStatus, Object orderObject, Object billObject){
        Map<String,Object> response = new HashMap<>();
        response.put("message", "Successfully created an order and bill");
        response.put("order object:", orderObject);
        response.put("bill object:", billObject);
        response.put("HttpStatus Code", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }
}
