package com.online.Smart_Online_Shopping_Platform.repository;

import com.online.Smart_Online_Shopping_Platform.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity,Integer> {
}
