package com.kichan.cookestore.repository;

import com.kichan.cookestore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
