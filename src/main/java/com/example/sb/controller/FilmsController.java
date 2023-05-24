package com.example.sb.controller;

import com.example.sb.entity.Directors;
import com.example.sb.entity.Films;
import com.example.sb.service.DirectorsService;
import com.example.sb.service.FilmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/films")
public class FilmsController extends BaseController<Films, FilmsService> {

    private final FilmsService filmsService;
    private final DirectorsService directorsService;

    protected FilmsController(FilmsService service, FilmsService filmsService, DirectorsService directorsService) {
        super(service);
        this.filmsService = filmsService;
        this.directorsService = directorsService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Films>> showAll() {
        return super.showAll();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<Films> showById(@RequestParam("id") UUID id) {
        return super.showById(id);
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<Films> create(@RequestBody Films entity) {
        return super.create(entity);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<Films> update(@RequestBody Films entity) {
        return super.update(entity);
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Films> delete(@RequestBody Films entity) {
        return super.delete(entity);
    }

    @PutMapping("/{filmId}/add_director")
    public ResponseEntity<Directors> addDirector(@PathVariable UUID filmId, @RequestBody Directors director) {
        return directorsService.addDirectorToFilm(filmId, director);
    }




}
