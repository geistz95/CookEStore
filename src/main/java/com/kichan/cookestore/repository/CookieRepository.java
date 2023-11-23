package com.kichan.cookestore.repository;


import com.kichan.cookestore.model.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CookieRepository extends JpaRepository<Cookie, Long> {

    /**
     * this method returns each amount of sales for each cookie
     * @return List of Cookies and its sales figures
     */

    @Query(value = "select * from cookie",
    countQuery = "Select count(*) from cookie group by cookie_name",
    nativeQuery = true)
    List<cookieSalesHelper> findCookieSales();

    public class cookieSalesHelper{
        private String cookie_name;
        private Integer amount;

        public cookieSalesHelper(String cookie_name, Integer amount){
            this.cookie_name=cookie_name;
            this.amount=amount;
        }

        public String getCookie_name() {
            return cookie_name;
        }

        public void setCookie_name(String cookie_name) {
            this.cookie_name = cookie_name;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }
}
