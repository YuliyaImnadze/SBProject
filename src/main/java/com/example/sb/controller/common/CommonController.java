package com.example.sb.controller.common;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.base.BaseEntityDtoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public interface CommonController<D extends BaseEntityDtoRequest,
        T extends BaseEntityDtoResponse> {

    @GetMapping
    ResponseEntity<List<T>> showAll();

    @GetMapping("/")
    ResponseEntity<?> showById(@RequestParam UUID id);

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid D entity);

    @PutMapping("/update")
    ResponseEntity<?> update(@RequestBody @Valid D entity);

    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestBody D entity);


}
