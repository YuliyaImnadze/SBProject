package com.example.sb.controller;

import com.example.sb.entity.BaseEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface CommonController<E extends BaseEntity> {

    @GetMapping
    ResponseEntity<List<E>> showAll();

    @GetMapping
    ResponseEntity<E> showById(@RequestParam UUID id);

    @PostMapping
    ResponseEntity<E> create(@RequestBody E entity);

    @PutMapping
    ResponseEntity<E> update(@RequestBody E entity);

    @DeleteMapping
    ResponseEntity<E> delete(@RequestBody E entity);


}
