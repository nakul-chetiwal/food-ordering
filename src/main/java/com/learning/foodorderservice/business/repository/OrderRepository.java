package com.learning.foodorderservice.business.repository;

import com.learning.foodorderservice.business.repository.model.OrderEntity;
import com.learning.foodorderservice.business.enums.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<List<OrderEntity>> findByOrderStateAndOrderDateGreaterThanEqual(OrderState orderState, LocalDate orderDate);

    Optional<List<OrderEntity>> findByOrderDateGreaterThanEqual(LocalDate orderDate);
}
