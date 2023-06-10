package com.example.sb.service.user;

import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.dto.user.UserDtoResponse;
import com.example.sb.entity.Order;
import com.example.sb.entity.User;
import com.example.sb.mapper.OrderMapper;
import com.example.sb.mapper.UserMapper;
import com.example.sb.repository.OrderRepository;
import com.example.sb.repository.UserRepository;
import com.example.sb.util.CustomPasswordEncoder;
import com.example.sb.service.common.BaseService;
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
        UserMapper>
        implements UserService, UserDetailsService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomPasswordEncoder customPasswordEncoder;

    public UserServiceImpl(UserRepository repository,
                           UserMapper mapper,
                           OrderRepository orderRepository,
                           OrderMapper orderMapper,
                           CustomPasswordEncoder customPasswordEncoder) {
        super(repository, mapper);
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customPasswordEncoder = customPasswordEncoder;
    }

    @Transactional
    @Override
    public UserDtoResponse save(UserDtoRequest entity) throws DataIntegrityViolationException {
        String encode = customPasswordEncoder.encode(entity.getPassword());
        entity.setPassword(encode);
        User saved = repository.save(mapper.toEntityRequest(entity));
        return mapper.toDtoResponse(saved);
    }


    @Transactional
    @Override
    public List<OrderDtoResponse> allOrders(UUID userId) throws UsernameNotFoundException {
        repository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<Order> orderByUser = orderRepository.findOrdersByUser(userId);
        return orderMapper.toDtoResponse(orderByUser);
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
