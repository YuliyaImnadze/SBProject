package com.example.sb.controller;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.film.FilmDtoRequest;
import com.example.sb.dto.film.FilmDtoResponse;
import com.example.sb.entity.Film;
import com.example.sb.service.FilmServiceImpl;
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
@RequestMapping("/films")
@Tag(name="Фильмы", description="Позволяет осуществять основные действия с фильмами")
public class FilmController extends BaseController<Film,
        FilmDtoRequest, FilmDtoResponse, FilmServiceImpl> {

    private final FilmServiceImpl filmService;

    protected FilmController(FilmServiceImpl service, FilmServiceImpl filmService) {
        super(service);
        this.filmService = filmService;
    }

    @Operation(
            summary = "Отображение всех фильмов",
            description = "Позволяет посмотреть весь список фильмов"
    )
    @GetMapping
    @Override
    public ResponseEntity<List<FilmDtoResponse>> showAll() {
        return super.showAll();
    }

    @Operation(
            summary = "Поиск фильма по ID",
            description = "Позволяет посмотреть данные конкретного фильма"
    )
    @GetMapping("/")
    @Override
    public ResponseEntity<BaseResponse<?>> showById(@RequestParam("id") UUID id) { // подумать над id
        return super.showById(id);
    }

    @Operation(
            summary = "Добаление нового фильма",
            description = "Позволяет добавить новый фильм"
    )
    @PostMapping("/create")
    @Override
    public ResponseEntity<BaseResponse<?>> create(@RequestBody FilmDtoRequest entity) {
        return super.create(entity);
    }

    @Operation(
            summary = "Обновление фильма",
            description = "Позволяет обновить данные о фильме"
    )
    @PutMapping("/update")
    @Override
    public ResponseEntity<BaseResponse<?>> update(@RequestBody FilmDtoRequest entity) {
        return super.update(entity);
    }

    @Operation(
            summary = "Удаление фильма",
            description = "Позволяет удалить данные о фильме"
    )
    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<String> delete(@RequestBody FilmDtoRequest entity) {
        return super.delete(entity);
    }

    @Operation(
            summary = "Добавление режиссера к фильму",
            description = "Позволяет добавить в список фильмов режиссера новый фильм"
    )
    @PutMapping("/add_director/")
    public ResponseEntity<BaseResponse<?>> addDirector(@RequestParam("directorId") UUID directorID,
                                                       @RequestParam("filmId") UUID filmId) {
        try {
            FilmDtoResponse filmDtoResponse = filmService.addDirectorToFilm(filmId, directorID);
            BaseResponse<FilmDtoResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, filmDtoResponse, LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        } catch (EntityNotFoundException | IllegalStateException e) {
            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        }
    }


}
