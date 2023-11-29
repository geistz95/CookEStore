package com.kichan.cookestore.repository;


import com.kichan.cookestore.enums.PaymentStatus;
import com.kichan.cookestore.model.Bill;
import com.kichan.cookestore.model.Customer;
import com.kichan.cookestore.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

@Repository
@EnableJpaRepositories
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query(value = "SELECT b.* FROM bill b " +
            "JOIN cookieorders o on b.bill_id = o.bill_id " +
            "JOIN customer c on o.customer_id = c.customer_id " +
            "WHERE c.customer_id = ?1 AND b.status = 'PENDING'", nativeQuery = true)
    Iterable<Bill> unpaidBills(Long customer_id);


}
