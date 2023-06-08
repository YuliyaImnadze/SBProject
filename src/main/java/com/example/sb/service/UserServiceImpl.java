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
import com.example.sb.security.CustomPasswordEncoder;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service(value = "SB_USER_SERVICE")
public class UserServiceImpl extends BaseService<User,
        UserDtoRequest, UserDtoResponse,
        UserRepository,
        UserMapperRequest, UserMapperResponse>
        implements UserDetailsService {

    private final OrderRepository orderRepository;
    private final OrderMapperResponse orderMapperResponse;
    private final CustomPasswordEncoder customPasswordEncoder;

    public UserServiceImpl(UserRepository repository,
                           UserMapperRequest mapperRequest, UserMapperResponse mapperResponse,
                           OrderRepository orderRepository,
                           OrderMapperResponse orderMapperResponse,
                           CustomPasswordEncoder customPasswordEncoder) {
        super(repository, mapperRequest, mapperResponse);
        this.orderRepository = orderRepository;
        this.orderMapperResponse = orderMapperResponse;
        this.customPasswordEncoder = customPasswordEncoder;
    }

    @Override
    public UserDtoResponse save(UserDtoRequest entity) throws DataIntegrityViolationException {
        String encode = customPasswordEncoder.encode(entity.getPassword());
        entity.setPassword(encode);
        User saved = repository.save(mapperRequest.toEntity(entity));
        return mapperResponse.toDto(saved);
    }


    @Transactional
    public List<OrderDtoResponse> allOrders(UUID userId) {
        repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Order> orderByUser = orderRepository.findOrdersByUser(userId);
        return orderMapperResponse.toDto(orderByUser);
    }


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole().getTitle())
                .build();
    }
}
