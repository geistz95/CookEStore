package com.kichan.cookestore.service;

import com.kichan.cookestore.exceptions.CookieNotFoundException;
import com.kichan.cookestore.exceptions.InvalidQuantityException;
import com.kichan.cookestore.model.Cookie;
import com.kichan.cookestore.repository.CookieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookieService {

    @Autowired
    private CookieRepository cookieRepository;



    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    private Cookie verifyCookieId(Long id){
        logger.info("Verifying cookie id : "+id);
        Optional<Cookie> c = cookieRepository.findById(id);
        if(c.isEmpty()){
            logger.info("Cookie with id "+ id + " is not found");
            throw new CookieNotFoundException("Cookie at id "+ id+ " is not found");
        }
        return c.get();
    }
    private void verifyQuantity(Integer amount){
        logger.info("Verifying cookie amount {}", amount);
        if(amount<=0){
            throw new InvalidQuantityException(amount + " Is not a valid amount, needs to be > 0");
        }
    }

    public Cookie createCookie(Cookie cookie){
        logger.info("Creating the cookie"+ cookie.getName());
        verifyQuantity(cookie.getQuantity());
        cookieRepository.save(cookie);
        return cookie;
    }

    public Cookie getCookieById(Long id){
        Cookie cookie = verifyCookieId(id);
        logger.info("Getting cookie +"+ cookie.getName());
        return cookie;
    }

    public void editCookieInfo(Long id,Cookie cookie){
        Cookie oldCookie = verifyCookieId(id);
        logger.info("Editing cookie details");
        oldCookie.setDescription(cookie.getDescription());
        oldCookie.setName(cookie.getName());
        oldCookie.setPrice(cookie.getPrice());
        verifyQuantity(cookie.getQuantity());
        oldCookie.setQuantity(cookie.getQuantity());
        logger.info("Saving edits");
        cookieRepository.save(oldCookie);
    }

    public void deleteCookieByID(Long id){
        cookieRepository.delete(verifyCookieId(id));
        logger.info("Delete successful for cookie id " + id);
    }

    public List<?> countCookieSales(){
        logger.info("Getting cookie sales");
        return cookieRepository.findCookieSales();
    }

    public Iterable<Cookie> getAllCookies() {
        logger.info("Getting all the cookie options");
        return cookieRepository.findAll();
    }
}
