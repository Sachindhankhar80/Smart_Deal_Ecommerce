package com.online.Smart_Online_Shopping_Platform.repository;

import com.online.Smart_Online_Shopping_Platform.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    public Seller findByEmail(String email);
}
