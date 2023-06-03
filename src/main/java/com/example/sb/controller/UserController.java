package com.example.sb.controller;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.dto.user.UserDtoResponse;
import com.example.sb.entity.User;
import com.example.sb.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name="Пользователи", description="Позволяет осуществять основные действия с пользователями")
public class UserController extends BaseController<User,
        UserDtoRequest, UserDtoResponse, UserServiceImpl> {

    private final UserServiceImpl userServiceImpl;

    protected UserController(UserServiceImpl service, UserServiceImpl userServiceImpl) {
        super(service);
        this.userServiceImpl = userServiceImpl;
    }

    @Operation(
            summary = "Отображение всех пользователей",
            description = "Позволяет посмотреть весь список пользователей"
    )
    @GetMapping
    @Override
    public ResponseEntity<List<UserDtoResponse>> showAll() {
        return super.showAll();
    }


    @Operation(
            summary = "Поиск пользователя по ID",
            description = "Позволяет посмотреть данные конкретного пользователя"
    )
    @GetMapping("/")
    @Override
    public ResponseEntity<BaseResponse<?>> showById(@RequestParam("id") UUID id) { // подумать над id
        return super.showById(id);
    }


    @Operation(
            summary = "Создание нового пользователя",
            description = "Позволяет создать нового пользователя"
    )
    @PostMapping("/create")
    @Override
    public ResponseEntity<BaseResponse<?>> create(@RequestBody UserDtoRequest entity) { return super.create(entity);
    }


    @Operation(
            summary = "Обновление данных пользователя",
            description = "Позволяет обновить данные о пользователе"
    )
    @PutMapping("/update")
    @Override
    public ResponseEntity<BaseResponse<?>> update(@RequestBody UserDtoRequest entity) {
        return super.update(entity);
    }


    @Operation(
            summary = "Удаление пользователя",
            description = "Позволяет удалить данные о пользователе"
    )
    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<String> delete(@RequestBody UserDtoRequest entity) {
        return super.delete(entity);
    }


    @Operation(
            summary = "Список всех арендованных/купленных фильмов у пользователя",
            description = "Позволяет посмотерть писок всех арендованных/купленных фильмов у пользователя"
    )
    @GetMapping("/orders/")
    public ResponseEntity<List<OrderDtoResponse>> allUserOrders(@RequestParam("id") UUID userId) {
        List<OrderDtoResponse> orderDtoResponses = userServiceImpl.allOrders(userId);
        return ResponseEntity.ok(orderDtoResponses);
    }

}
