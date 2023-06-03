package com.example.sb.controller;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.role.RoleDtoRequest;
import com.example.sb.dto.role.RoleDtoResponse;
import com.example.sb.entity.Role;
import com.example.sb.service.RoleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
@Tag(name="Роли", description="Позволяет осуществять основные действия с ролями")
public class RoleController extends BaseController<Role,
        RoleDtoRequest, RoleDtoResponse, RoleServiceImpl> {

    protected RoleController(RoleServiceImpl service) {
        super(service);
    }

    @Operation(
            summary = "Отображение всех ролей",
            description = "Позволяет посмотреть все роли"
    )
    @GetMapping
    @Override
    public ResponseEntity<List<RoleDtoResponse>> showAll() {
        return super.showAll();
    }

    @Operation(
            summary = "Поиск роли по ID",
            description = "Позволяет посмотреть название и описаноие роли"
    )
    @GetMapping("/")
    @Override
    public ResponseEntity<BaseResponse<?>> showById(@RequestParam("id") UUID id) { // подумать над id
        return super.showById(id);
    }


    @Operation(
            summary = "Создание новой роли",
            description = "Позволяет создать новую роль"
    )
    @PostMapping("/create")
    @Override
    public ResponseEntity<BaseResponse<?>> create(@RequestBody RoleDtoRequest entity) {
        return super.create(entity);
    }


    @Operation(
            summary = "Обновление роли",
            description = "Позволяет обновить данные в роли"
    )
    @PutMapping("/update")
    @Override
    public ResponseEntity<BaseResponse<?>> update(@RequestBody RoleDtoRequest entity) {
        return super.update(entity);
    }


        @Operation(
            summary = "Удаление роли",
            description = "Позволяет удалить роль"
    )
    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<String> delete(@RequestBody RoleDtoRequest entity) {
        return super.delete(entity);
    }
}
