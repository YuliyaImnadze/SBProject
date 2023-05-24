package com.example.sb.repository;

import com.example.sb.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrdersRepository extends CommonRepository<Orders> {
    @Query("select o from Orders o where o.owner.id = ?1")
    List<Orders> findOrdersByUser(UUID id);


}