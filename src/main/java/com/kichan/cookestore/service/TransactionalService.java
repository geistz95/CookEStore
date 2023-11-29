package com.kichan.cookestore.service;

import com.kichan.cookestore.enums.PaymentStatus;
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
    public Bill calculateOrderTotalToBill(Order order){
        List<Cookie> cookieList = order.getCookies();
        Bill bill = new Bill();
        bill.setStatus(PaymentStatus.PENDING);
        bill.setOrder(order);
        bill.setCustomer_name(order.getCustomerName());
        double totalPrice = 0.0;
        for(Cookie s  : cookieList){
            totalPrice+=s.getPrice();
        }
        billRepository.save(bill);
        order.setBill(bill);
        return bill;
    }

    public Bill calculateNewBill(Order oldOrder) {
        List<Cookie> cookieList = oldOrder.getCookies();
        oldOrder.getBill().setStatus(PaymentStatus.ORDER_CHANGED);
        Bill bill = new Bill();
        bill.setStatus(PaymentStatus.PENDING);
        bill.setOrder(oldOrder);
        bill.setCustomer_name(oldOrder.getCustomerName());
        double totalPrice = 0.0;
        for(Cookie s  : cookieList){
            totalPrice+=s.getPrice()*s.getQuantity();
        }
        billRepository.save(bill);
        oldOrder.setBill(bill);
        return bill;
    }
}
