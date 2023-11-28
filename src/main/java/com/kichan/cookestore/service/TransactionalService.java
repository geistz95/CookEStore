package com.kichan.cookestore.service;

import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.model.Cookie;
import com.kichan.cookestore.model.Order;
import com.kichan.cookestore.repository.BillRepository;
import com.kichan.cookestore.repository.CookieRepository;
import com.kichan.cookestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionalService {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Transactional
    public void calculateOrderTotalToBill(Order order, Bill bill){
        List<Cookie> cookieList = order.getCookies();
        double totalPrice = 0.0;
        for(Cookie s  : cookieList){
            totalPrice+=s.getPrice()*s.getQuantity();
        }
    }
}
