package com.kichan.cookestore.service;

import com.kichan.cookestore.exceptions.CookieNotFoundException;
import com.kichan.cookestore.model.Cookie;
import com.kichan.cookestore.repository.CookieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CookieService {

    @Autowired
    private CookieRepository cookieRepository;

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    private Cookie verifyCookieId(Long id){
        Optional<Cookie> c = cookieRepository.findById(id);
        if(c.isEmpty()){
            logger.info("Cooke with id "+ id + " is not found");
            throw new CookieNotFoundException("Cookie at id "+ id+ " is not found");
        }
        return c.get();
    }

    public void createCookie(Cookie cookie){
        logger.info("Creating the cookie"+ cookie.getName());
        cookieRepository.save(cookie);
    }

    public Cookie getCookieById(Long id){
        Cookie cookie = verifyCookieId(id);
        logger.info("Getting cookie +"+ cookie.getName());
        return cookie;
    }

    public void editCookieInfo(Long id,Cookie cookie){
        logger.info("Verifying cookie id : "+id);
        Cookie oldCookie = verifyCookieId(id);
        oldCookie.setDescription(cookie.getDescription());
        oldCookie.setName(cookie.getName());
        oldCookie.setPrice(cookie.getPrice());

    }

}
