package com.example.sb.controller.user;

import com.example.sb.controller.common.BaseController;
import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.dto.user.UserDtoResponse;
import com.example.sb.entity.User;
import com.example.sb.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Пользователи", description = "Позволяет осуществять основные действия с пользователями")
public class UserControllerImpl extends BaseController<User,
        UserDtoRequest, UserDtoResponse, UserService>
        implements UserController {

    protected UserControllerImpl(UserService service) {
        super(service);
    }

    @Operation(
            summary = "Отображение всех пользователей",
            description = "Позволяет посмотреть весь список пользователей"
    )
    @Override
    public ResponseEntity<List<UserDtoResponse>> showAll() {
        return super.showAll();
    }


    @Operation(
            summary = "Поиск пользователя по ID",
            description = "Позволяет посмотреть данные конкретного пользователя"
    )
    @Override
    public ResponseEntity<BaseResponse<UserDtoResponse>> showById(@RequestParam("id") UUID id) { // подумать над id
        return super.showById(id);
    }


    @Operation(
            summary = "Создание нового пользователя",
            description = "Позволяет создать нового пользователя"
    )
    @Override
    public ResponseEntity<BaseResponse<UserDtoResponse>> create(@RequestBody @Valid UserDtoRequest entity) {
            UserDtoResponse userDtoResponse = service.save(entity);
            BaseResponse<UserDtoResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, userDtoResponse);
            return ResponseEntity.ok(tBaseResponse);
    }


    @Operation(
            summary = "Обновление данных пользователя",
            description = "Позволяет обновить данные о пользователе"
    )
    @Override
    public ResponseEntity<BaseResponse<UserDtoResponse>> update(@RequestBody @Valid UserDtoRequest entity) {
        return super.update(entity);
    }


    @Operation(
            summary = "Удаление пользователя",
            description = "Позволяет удалить данные о пользователе"
    )
    @Override
    public ResponseEntity<String> delete(@RequestBody UserDtoRequest entity) {
        return super.delete(entity);
    }


    @Operation(
            summary = "Список всех арендованных/купленных фильмов у пользователя",
            description = "Позволяет посмотерть писок всех арендованных/купленных фильмов у пользователя"
    )
    @Override
    public ResponseEntity<List<OrderDtoResponse>> allUserOrders(@RequestParam("id") UUID userId) {
        List<OrderDtoResponse> orderDtoResponses = service.allOrders(userId);
        return ResponseEntity.ok(orderDtoResponses);
    }

}
