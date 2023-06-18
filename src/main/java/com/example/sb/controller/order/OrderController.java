package com.example.sb.controller.order;


import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.order.OrderDtoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@RequestMapping("/orders")
public interface OrderController {

    @PostMapping("/create/")
    ResponseEntity<BaseResponse<?>> rentOrBuyFilm(@RequestParam("filmID") List<UUID> filmsID,
                                                  @RequestParam("userId") UUID userId,
                                                  @RequestBody OrderDtoRequest order);

}
