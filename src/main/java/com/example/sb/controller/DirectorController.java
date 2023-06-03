package com.example.sb.controller;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.director.DirectorDtoRequest;
import com.example.sb.dto.director.DirectorDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.service.DirectorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/directors")
@Tag(name="Режиссеры", description="Позволяет осуществять основные действия с режиссерами")
public class DirectorController extends BaseController<Director,
        DirectorDtoRequest, DirectorDtoResponse,
        DirectorServiceImpl> {

    private final DirectorServiceImpl directorServiceImpl;

    protected DirectorController(DirectorServiceImpl service, DirectorServiceImpl directorServiceImpl) {
        super(service);
        this.directorServiceImpl = directorServiceImpl;
    }

    @Operation(
            summary = "Отображение всех режиссеров",
            description = "Позволяет посмотреть весь список режиссеров"
    )
    @GetMapping
    @Override
    public ResponseEntity<List<DirectorDtoResponse>> showAll() {
        return super.showAll();
    }

    @Operation(
            summary = "Поиск режиссера по ID",
            description = "Позволяет посмотреть данные конкретного режиссера"
    )
    @GetMapping("/")
    @Override
    public ResponseEntity<BaseResponse<?>> showById(@RequestParam("id") @Parameter(description = "Идентификатор пользователя")UUID id) {
        return super.showById(id);
    }

    @Operation(
            summary = "Добаление нового режиссера",
            description = "Позволяет добавить нового режиссера"
    )
    @PostMapping("/create")
    @Override
    public ResponseEntity<BaseResponse<?>> create(@RequestBody DirectorDtoRequest entity) {
        return super.create(entity);
    }

    @Operation(
            summary = "Обновление данных режиссера",
            description = "Позволяет обновить данные о режиссере"
    )
    @PutMapping("/update")
    @Override
    public ResponseEntity<BaseResponse<?>> update(@RequestBody DirectorDtoRequest entity) {
        return super.update(entity);
    }

    @Operation(
            summary = "Удаление режиссера",
            description = "Позволяет удалить данные о режиссере"
    )
    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<String> delete(@RequestBody DirectorDtoRequest entity) {
        return super.delete(entity);
    }

    @Operation(
            summary = "Добавление фильма к режиссеру",
            description = "Позволяет добавить в список фильмов режиссера новый фильм"
    )
    @PutMapping("/add_film/")
    public ResponseEntity<BaseResponse<?>> addFilm(@RequestParam("directorId") UUID directorID,
                                                       @RequestParam("filmId") UUID filmId) {
        try {
            DirectorDtoResponse directorDtoResponse = directorServiceImpl.addFilmToDirector(filmId, directorID);
            BaseResponse<DirectorDtoResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, directorDtoResponse, LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        } catch (EntityNotFoundException | IllegalStateException e) {
            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        }
    }


}
