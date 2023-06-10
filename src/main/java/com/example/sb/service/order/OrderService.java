package com.example.sb.service.order;

import com.example.sb.dto.order.OrderDtoRequest;
import com.example.sb.dto.order.OrderDtoResponse;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    OrderDtoResponse rentOrBuyFilm(List<UUID> filmsId, UUID userId, OrderDtoRequest orderDto) throws EntityNotFoundException;

}
