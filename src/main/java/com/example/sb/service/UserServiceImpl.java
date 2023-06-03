package com.example.sb.service;

import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.dto.user.UserDtoResponse;
import com.example.sb.entity.Order;
import com.example.sb.entity.User;
import com.example.sb.mapper.order.OrderMapperResponse;
import com.example.sb.mapper.user.UserMapperRequest;
import com.example.sb.mapper.user.UserMapperResponse;
import com.example.sb.repository.OrderRepository;
import com.example.sb.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service(value = "SB_USER_SERVICE")
public class UserServiceImpl extends BaseService<User,
        UserDtoRequest, UserDtoResponse,
        UserRepository,
        UserMapperRequest, UserMapperResponse> {

    private final OrderRepository orderRepository;
    private final OrderMapperResponse orderMapperResponse;

    public UserServiceImpl(UserRepository repository,
                           UserMapperRequest mapperRequest, UserMapperResponse mapperResponse,
                           OrderRepository orderRepository,
                           OrderMapperResponse orderMapperResponse) {
        super(repository, mapperRequest, mapperResponse);
        this.orderRepository = orderRepository;
        this.orderMapperResponse = orderMapperResponse;
    }

    @Transactional
    @Override
    public UserDtoResponse update(UserDtoRequest entity)throws EntityNotFoundException {
        User updatedEntity = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        mapperRequest.partialUpdate(updatedEntity,entity);
        User savedEntity = repository.save(updatedEntity);
        return mapperResponse.toDto(savedEntity);
    }


    @Transactional
    public List<OrderDtoResponse> allOrders(UUID userId) {
        repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Order> orderByUser = orderRepository.findOrdersByUser(userId);
        return orderMapperResponse.toDto(orderByUser);
    }


}
