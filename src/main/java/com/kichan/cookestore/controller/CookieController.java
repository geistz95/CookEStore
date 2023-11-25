package com.kichan.cookestore.controller;

import com.kichan.cookestore.model.Cookie;
import com.kichan.cookestore.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

    @Autowired
    private CookieRepository cookieRepository;

    @PostMapping("/cookies")
    private ResponseEntity<?> createCookie(@RequestBody Cookie cookie){

    }
}
