package com.example.sb.controller.order;

import com.example.sb.controller.common.BaseController;
import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.order.OrderDtoRequest;
import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.entity.Order;
import com.example.sb.service.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Заказы", description = "Позволяет осуществять основные действия с заказами")
public class OrderControllerImpl extends BaseController<Order,
        OrderDtoRequest, OrderDtoResponse, OrderService>
        implements OrderController {

    protected OrderControllerImpl(OrderService service) {
        super(service);
    }

    @Operation(
            summary = "Отображение всех заказов",
            description = "Позволяет посмотреть все заказы всех пользователей"
    )
    @Override
    public ResponseEntity<List<OrderDtoResponse>> showAll() {
        return super.showAll();
    }

    @Operation(
            summary = "Поиск заказа по ID",
            description = "Позволяет посмотреть данные конкретного заказа"
    )
    @Override
    public ResponseEntity<BaseResponse<OrderDtoResponse>> showById(@RequestParam("id") UUID id) { // подумать над id
        return super.showById(id);
    }


    @Operation(
            summary = "Создание нового заказа",
            description = "Позволяет создать новый заказ только через json"
    )
    @Override
    public ResponseEntity<BaseResponse<OrderDtoResponse>> create(@RequestBody OrderDtoRequest entity) {
        return super.create(entity);
    }


    @Operation(
            summary = "Обновление заказа",
            description = "Позволяет обновить данные в заказе"
    )
    @Override
    public ResponseEntity<BaseResponse<OrderDtoResponse>> update(@RequestBody OrderDtoRequest entity) {
        return super.update(entity);
    }


    @Operation(
            summary = "Удаление заказа",
            description = "Позволяет удалить заказ"
    )
    @Override
    public ResponseEntity<String> delete(@RequestBody OrderDtoRequest entity) {
        return super.delete(entity);
    }


    @Operation(
            summary = "Создание нового заказа",
            description = "Позволяет создать новый заказ передав данные через URL"
    )
    @Override
    public ResponseEntity<BaseResponse<?>> rentOrBuyFilm(@RequestParam("filmID") List<UUID> filmsID,
                                                         @RequestParam("userId") UUID userId,
                                                         @RequestBody OrderDtoRequest order) {
            OrderDtoResponse orderDtoResponse = service.rentOrBuyFilm(filmsID, userId, order);
            BaseResponse<OrderDtoResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, orderDtoResponse, LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
    }


}
