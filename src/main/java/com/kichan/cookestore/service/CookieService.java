package com.kichan.cookestore.service;

import com.kichan.cookestore.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    @Autowired
    private CookieRepository cookieRepository;


}
