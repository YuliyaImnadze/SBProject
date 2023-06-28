package com.example.sb.controller.director;

import com.example.sb.controller.common.BaseController;
import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.director.DirectorDtoRequest;
import com.example.sb.dto.director.DirectorDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.service.director.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Режиссеры", description = "Позволяет осуществять основные действия с режиссерами")
public class DirectorControllerImpl extends BaseController<Director,
        DirectorDtoRequest, DirectorDtoResponse,
        DirectorService>
        implements DirectorController {

    protected DirectorControllerImpl(DirectorService service) {
        super(service);
    }

    @Operation(
            summary = "Отображение всех режиссеров",
            description = "Позволяет посмотреть весь список режиссеров"
    )
    @Override
    public ResponseEntity<List<DirectorDtoResponse>> showAll() {
        return super.showAll();
    }

    @Operation(
            summary = "Поиск режиссера по ID",
            description = "Позволяет посмотреть данные конкретного режиссера"
    )
    @Override
    public ResponseEntity<BaseResponse<DirectorDtoResponse>> showById(
            @RequestParam("id") @Parameter(description = "Идентификатор пользователя") UUID id) {
        return super.showById(id);
    }

    @Operation(
            summary = "Добаление нового режиссера",
            description = "Позволяет добавить нового режиссера"
    )
    @Override
    public ResponseEntity<BaseResponse<DirectorDtoResponse>> create(@RequestBody DirectorDtoRequest entity) {
        return super.create(entity);
    }

    @Operation(
            summary = "Обновление данных режиссера",
            description = "Позволяет обновить данные о режиссере"
    )
    @Override
    public ResponseEntity<BaseResponse<DirectorDtoResponse>> update(@RequestBody DirectorDtoRequest entity) {
        return super.update(entity);
    }

    @Operation(
            summary = "Удаление режиссера",
            description = "Позволяет удалить данные о режиссере"
    )
    @Override
    public ResponseEntity<String> delete(@RequestBody DirectorDtoRequest entity) {
        return super.delete(entity);
    }

    @Operation(
            summary = "Добавление фильма к режиссеру",
            description = "Позволяет добавить в список фильмов режиссера новый фильм"
    )

    @Override
    public ResponseEntity<BaseResponse<?>> addFilm(@RequestParam("directorId") UUID directorID,
                                                   @RequestParam("filmId") UUID filmId) {
            DirectorDtoResponse directorDtoResponse = service.addFilmToDirector(filmId, directorID);
            BaseResponse<DirectorDtoResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, directorDtoResponse);
            return ResponseEntity.ok(tBaseResponse);
    }


}
