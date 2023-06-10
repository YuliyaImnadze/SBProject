package com.example.sb.service.user;

import com.example.sb.dto.order.OrderDtoResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<OrderDtoResponse> allOrders(UUID userId) throws UsernameNotFoundException;

}
