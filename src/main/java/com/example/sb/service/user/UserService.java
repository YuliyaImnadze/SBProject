package com.example.sb.service.user;

import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.dto.user.UserDtoResponse;
import com.example.sb.entity.User;
import com.example.sb.service.common.CommonService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.UUID;

public interface UserService extends CommonService<User, UserDtoRequest, UserDtoResponse> {

    List<OrderDtoResponse> allOrders(UUID userId) throws UsernameNotFoundException;

}
