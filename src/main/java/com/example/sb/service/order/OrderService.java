package com.example.sb.service.order;

import com.example.sb.dto.order.OrderDtoRequest;
import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.entity.Order;
import com.example.sb.service.common.CommonService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public interface OrderService extends CommonService<Order, OrderDtoRequest, OrderDtoResponse> {

    OrderDtoResponse rentOrBuyFilm(List<UUID> filmsId, UUID userId, OrderDtoRequest orderDto) throws EntityNotFoundException;

}
