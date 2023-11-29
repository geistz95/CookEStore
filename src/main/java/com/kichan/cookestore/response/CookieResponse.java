package com.kichan.cookestore.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CookieResponse {
    public static ResponseEntity<?> createCookieResponse(HttpStatus httpStatus, Object responseObject){
        Map<String, Object> response = new HashMap<>();
        response.put("message","Successful created the cookie!");
        response.put("data", responseObject);
        response.put("HttpStatus Code", httpStatus);
        return new ResponseEntity<>(response,httpStatus);
    }

    public static ResponseEntity<?> getCookieAllResponse(HttpStatus httpStatus, Object object){
        Map<String, Object> response = new HashMap<>();
        response.put("message","Successfully got the cookies!");
        response.put("data", object);
        response.put("HttpStatus code", httpStatus);
        return new ResponseEntity<>(response,httpStatus);
    }

    public static ResponseEntity<?> getACookieResponse(HttpStatus httpStatus, Object object){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Sucessfully got the cookie!");
        response.put("data", object);
        response.put("HttpStatus code", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }


}
