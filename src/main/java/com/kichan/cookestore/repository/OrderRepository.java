package com.kichan.cookestore.repository;

import com.kichan.cookestore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * This query returns orders that a customer has
     */
    @Query(value = "select o.* from order o join customer customer_id on o.customer_id = customer.customer_id where order.customer_id =?1", nativeQuery = true)
    Iterable<Order> findOrdersBycustomer_id(Long customer_id);

}
