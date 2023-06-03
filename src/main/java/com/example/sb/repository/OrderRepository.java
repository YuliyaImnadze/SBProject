package com.example.sb.repository;

import com.example.sb.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CommonRepository<Order> {
    @Query("select o from Order o where o.owner.id = ?1")
    List<Order> findOrdersByUser(UUID id);


}