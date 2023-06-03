package com.example.sb.controller;

import com.example.sb.dto.BaseEntityDtoRequest;
import com.example.sb.dto.BaseEntityDtoResponse;
import com.example.sb.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface CommonController<E extends BaseEntity, D extends BaseEntityDtoRequest,
        T extends BaseEntityDtoResponse> {

    @GetMapping
    ResponseEntity<List<T>> showAll();

    @GetMapping
    ResponseEntity<?> showById(@RequestParam UUID id);

    @PostMapping
    ResponseEntity<?> create(@RequestBody D entity);

    @PutMapping
    ResponseEntity<?> update(@RequestBody D entity);

    @DeleteMapping
    ResponseEntity<String> delete(@RequestBody D entity);


}
