package com.kichan.cookestore.repository;


import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.model.Customer;
import com.kichan.cookestore.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    public static Specification<Bill> hasCustomerBills(Long customer_id){
        return(root, query, criteriaBuilder) -> {
            Join<Bill, Order> orderJoin= root.join("order_id");
            return criteriaBuilder.equal(orderJoin.get("customer_id"), customer_id);
        };
    }

}
