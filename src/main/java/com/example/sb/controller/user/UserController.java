package com.example.sb.controller.user;

import com.example.sb.dto.order.OrderDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
public interface UserController {

    @GetMapping("/orders/")
    ResponseEntity<List<OrderDtoResponse>> allUserOrders(@RequestParam("id") UUID userId);

}
