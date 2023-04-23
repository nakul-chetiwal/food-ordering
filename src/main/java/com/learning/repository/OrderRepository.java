package com.learning.repository;

import com.learning.enums.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.model.entity.OrderEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<List<OrderEntity>> findByOrderStateAndOrderDateGreaterThanEqual(OrderState orderState, LocalDate orderDate);

    Optional<List<OrderEntity>> findByOrderDateGreaterThanEqual(LocalDate orderDate);
}
