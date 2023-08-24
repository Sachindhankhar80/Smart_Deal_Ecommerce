package com.online.Smart_Online_Shopping_Platform.repository;

import com.online.Smart_Online_Shopping_Platform.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRespository extends JpaRepository<Card,Integer> {

    public Card findByCardNo(String cardNo);
}
