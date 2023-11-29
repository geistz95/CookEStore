package com.kichan.cookestore.controller;

import com.kichan.cookestore.exceptions.CookieNotFoundException;
import com.kichan.cookestore.model.Order;
import com.kichan.cookestore.repository.OrderRepository;
import com.kichan.cookestore.service.BillService;
import com.kichan.cookestore.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static com.kichan.cookestore.response.OrderResponse.*;

import java.net.URI;

@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private BillService billService;
    private static final Logger logger = LoggerFactory.getLogger(CookieController.class);

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        HttpHeaders responseHeader = new HttpHeaders();
        logger.info("Creating new cookie URI");
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
       // return new ResponseEntity<>(order,HttpStatus.OK);
                if(order.getCookies()!=null){ return new ResponseEntity<>(orderService.createOrder(order),HttpStatus.OK);}
        else{
            throw new CookieNotFoundException("No Cookies here");
        }
    }


    @PutMapping("/orders/{order_id}")
    public ResponseEntity<?> editOrder(@PathVariable Long order_id, @RequestBody Order order){
        orderService.editOrder(order_id,order);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }



    @GetMapping("/orders/{order_id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long order_id){
        return new ResponseEntity<>(orderService.getOrder(order_id), HttpStatus.OK);
    }


    @DeleteMapping("/orders/{order_id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long order_id){
        orderService.cancelOrder(order_id);
        return new ResponseEntity<>("Order ID "+order_id+" has been cancelled",HttpStatus.ACCEPTED);
    }

}
