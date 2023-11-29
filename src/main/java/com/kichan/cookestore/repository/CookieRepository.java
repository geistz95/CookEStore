package com.kichan.cookestore.repository;


import com.kichan.cookestore.model.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;


@Repository
@EnableJpaRepositories
public interface CookieRepository extends JpaRepository<Cookie, Long> {

    /**
     * this method returns each amount of sales for each cookie
     * @return List of Cookies and its sales figures
     */

    @Query(value = "SELECT c.name, COUNT(co) " +
            "FROM Order o " +
            "JOIN o.cookies co " +
            "JOIN co.cookie c " +
            "GROUP BY c.cookie_id")
    List<Object[]> findCookieSales();

}
