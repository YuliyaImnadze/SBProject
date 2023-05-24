package com.example.sb.controller;

import com.example.sb.entity.Directors;
import com.example.sb.entity.Films;
import com.example.sb.service.DirectorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/directors")
public class DirectorsController extends BaseController<Directors, DirectorsService> {

    private final DirectorsService directorsService;

    protected DirectorsController(DirectorsService service, DirectorsService directorsService) {
        super(service);
        this.directorsService = directorsService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Directors>> showAll() {
        return super.showAll();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<Directors> showById(@RequestParam("id") UUID id) {
        return super.showById(id);
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<Directors> create(@RequestBody Directors entity) {
        return super.create(entity);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<Directors> update(@RequestBody Directors entity) {
        return super.update(entity);
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Directors> delete(@RequestBody Directors entity) {
        return super.delete(entity);
    }

    @PutMapping("/{directorID}/add_film")
    public ResponseEntity<Directors> addDirector(@PathVariable UUID directorID, @RequestBody Films film) {
        return directorsService.addFilmToDirector(directorID, film);
    }


}
