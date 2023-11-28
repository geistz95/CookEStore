package com.kichan.cookestore.controller;

import com.kichan.cookestore.model.Cookie;
import com.kichan.cookestore.repository.CookieRepository;
import com.kichan.cookestore.service.CookieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CookieController {

    @Autowired
    private CookieService cookieService;

    private static final Logger logger = LoggerFactory.getLogger(CookieController.class);

    @PostMapping("/cookies")
    public ResponseEntity<?> createCookie(@RequestBody Cookie cookie){
        HttpHeaders responseHeader = new HttpHeaders();
        //This next line builds the URI link from the deposit
        logger.info("Creating new cookie URI");
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cookie.getCookie_id()).toUri();
        responseHeader.setLocation(newPollUri);

        logger.info("Post Request received : creating cookie");
        cookieService.createCookie(cookie);
        logger.info("Returning successful post request");
        //Return custom response
    }

    @GetMapping("/cookies")
    public ResponseEntity<?> getAllCookies(){
        cookieService.getAllCookies();
        //return custom response

    }

    @GetMapping("/cookies/{cookie_id}")
    public ResponseEntity getCookieById(@PathVariable Long cookie_id){
        cookieService.getCookieById(cookie_id);
        //return custome response
    }

}
