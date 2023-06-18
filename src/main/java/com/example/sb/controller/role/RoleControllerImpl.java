package com.example.sb.controller.role;

import com.example.sb.controller.common.BaseController;
import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.role.RoleDtoRequest;
import com.example.sb.dto.role.RoleDtoResponse;
import com.example.sb.entity.Role;
import com.example.sb.service.role.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Роли", description = "Позволяет осуществять основные действия с ролями")
public class RoleControllerImpl extends BaseController<Role,
        RoleDtoRequest, RoleDtoResponse, RoleService>
        implements RoleController {

    protected RoleControllerImpl(RoleService service) {
        super(service);
    }

    @Operation(
            summary = "Отображение всех ролей",
            description = "Позволяет посмотреть все роли"
    )
    @Override
    public ResponseEntity<List<RoleDtoResponse>> showAll() {
        return super.showAll();
    }

    @Operation(
            summary = "Поиск роли по ID",
            description = "Позволяет посмотреть название и описаноие роли"
    )
    @Override
    public ResponseEntity<BaseResponse<RoleDtoResponse>> showById(@RequestParam("id") UUID id) { // подумать над id
        return super.showById(id);
    }


    @Operation(
            summary = "Создание новой роли",
            description = "Позволяет создать новую роль"
    )
    @Override
    public ResponseEntity<BaseResponse<RoleDtoResponse>> create(@RequestBody RoleDtoRequest entity) {
        return super.create(entity);
    }


    @Operation(
            summary = "Обновление роли",
            description = "Позволяет обновить данные в роли"
    )
    @Override
    public ResponseEntity<BaseResponse<RoleDtoResponse>> update(@RequestBody RoleDtoRequest entity) {
        return super.update(entity);
    }


    @Operation(
            summary = "Удаление роли",
            description = "Позволяет удалить роль"
    )
    @Override
    public ResponseEntity<String> delete(@RequestBody RoleDtoRequest entity) {
        return super.delete(entity);
    }
}
