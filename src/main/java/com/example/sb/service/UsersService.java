package com.example.sb.service;

import com.example.sb.entity.Orders;
import com.example.sb.entity.Users;
import com.example.sb.repository.OrdersRepository;
import com.example.sb.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService extends BaseService<Users, UsersRepository> {

    private final OrdersRepository ordersRepository;

    public UsersService(UsersRepository repository, OrdersRepository ordersRepository) {
        super(repository);
        this.ordersRepository = ordersRepository;
    }

    @Transactional
    @Override
    public Optional<Users> update(Users entity) {
        Users updated = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        updated.setLogin(entity.getLogin());
        updated.setPassword(entity.getPassword());
        updated.setFirstName(entity.getFirstName());
        updated.setLastName(entity.getLastName());
        updated.setMiddleName(entity.getMiddleName());
        updated.setBirthDate(entity.getBirthDate());
        updated.setPhone(entity.getPhone());
        updated.setAddress(entity.getAddress());
        updated.setEmail(entity.getEmail());
        updated.setCreatedWhen(entity.getCreatedWhen());
        updated.setRole(entity.getRole());
        return Optional.of(repository.save(updated));
    }


    @Transactional
    public ResponseEntity<List<Orders>> allOrders(UUID userId) {
        repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Orders> ordersByUser = ordersRepository.findOrdersByUser(userId);
        return ResponseEntity.ok(ordersByUser);
    }


}
