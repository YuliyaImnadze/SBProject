package com.example.sb.controller;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.film.FilmDtoResponse;
import com.example.sb.dto.order.OrderDtoRequest;
import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.entity.Order;
import com.example.sb.service.OrderServiceImpl;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@Tag(name = "Заказы", description = "Позволяет осуществять основные действия с заказами")
public class OrderController extends BaseController<Order,
        OrderDtoRequest, OrderDtoResponse, OrderServiceImpl> {

    private final OrderServiceImpl orderServiceImpl;

    protected OrderController(OrderServiceImpl service, OrderServiceImpl orderServiceImpl) {
        super(service);
        this.orderServiceImpl = orderServiceImpl;
    }

    @Operation(
            summary = "Отображение всех заказов",
            description = "Позволяет посмотреть все заказы всех пользователей"
    )
    @GetMapping
    @Override
    public ResponseEntity<List<OrderDtoResponse>> showAll() {
        return super.showAll();
    }

    @Operation(
            summary = "Поиск заказа по ID",
            description = "Позволяет посмотреть данные конкретного заказа"
    )
    @GetMapping("/")
    @Override
    public ResponseEntity<BaseResponse<?>> showById(@RequestParam("id") UUID id) { // подумать над id
        return super.showById(id);
    }


    @Operation(
            summary = "Создание нового заказа",
            description = "Позволяет создать новый заказ только через json"
    )
    @PostMapping("/create")
    @Override
    public ResponseEntity<BaseResponse<?>> create(@RequestBody OrderDtoRequest entity) {
        return super.create(entity);
    }


    @Operation(
            summary = "Обновление заказа",
            description = "Позволяет обновить данные в заказе"
    )
    @PutMapping("/update")
    @Override
    public ResponseEntity<BaseResponse<?>> update(@RequestBody OrderDtoRequest entity) {
        return super.update(entity);
    }


    //    @Operation(
//            summary = "Удаление заказа",
//            description = "Позволяет удалить заказ"
//    )
    @Hidden
    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<String> delete(@RequestBody OrderDtoRequest entity) {
        return super.delete(entity);
    }


    @Operation(
            summary = "Создание нового заказа",
            description = "Позволяет создать новый заказ передав данные через URL"
    )
    @PostMapping("/create/")
    public ResponseEntity<BaseResponse<?>> rentOrBuyFilm(@RequestParam("filmID") List<UUID> filmsID,
                                                         @RequestParam("userId") UUID userId,
                                                         @RequestBody OrderDtoRequest order) {
        try {
            OrderDtoResponse orderDtoResponse = orderServiceImpl.rentOrBuyFilm(filmsID, userId, order);
            BaseResponse<OrderDtoResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, orderDtoResponse, LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        } catch (EntityNotFoundException e) {
            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        }
    }


}
