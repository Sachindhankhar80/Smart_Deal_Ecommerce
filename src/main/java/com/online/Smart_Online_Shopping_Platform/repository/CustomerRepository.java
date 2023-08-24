package com.online.Smart_Online_Shopping_Platform.repository;

import com.online.Smart_Online_Shopping_Platform.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer findByMobNo(String mobileNo);

    public Customer findByEmail(String email);
}