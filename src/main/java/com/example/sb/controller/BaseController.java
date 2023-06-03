package com.example.sb.controller;


import com.example.sb.dto.BaseEntityDtoRequest;
import com.example.sb.dto.BaseEntityDtoResponse;
import com.example.sb.dto.BaseResponse;
import com.example.sb.entity.BaseEntity;
import com.example.sb.service.CommonService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class BaseController<E extends BaseEntity,
        D extends BaseEntityDtoRequest, T extends BaseEntityDtoResponse,
        S extends CommonService<E, D, T>>
        implements CommonController<E, D, T> {

    private final S service;

    protected BaseController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<T>> showAll() {
        List<T> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<BaseResponse<?>> showById(@RequestParam UUID id) {
        try {
            T byId = service.findById(id);
            BaseResponse<T> tBaseResponse = new BaseResponse<>(HttpStatus.OK, byId, LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        } catch (EntityNotFoundException e) {
            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        }
    }

    @Override
    public ResponseEntity<BaseResponse<?>> create(@RequestBody D entity) {
        try {
            T saved = service.save(entity);
            BaseResponse<T> tBaseResponse = new BaseResponse<>(HttpStatus.OK, saved, LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        } catch (DataIntegrityViolationException e) {
            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.CONFLICT, e.getMessage(), LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        }
    }


    @Override
    public ResponseEntity<BaseResponse<?>> update(D entity) {
        try {
            T updated = service.update(entity);
            BaseResponse<T> tBaseResponse = new BaseResponse<>(HttpStatus.OK, updated, LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        } catch (EntityNotFoundException e) {
            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        }

    }

    @Hidden
    @Override
    public ResponseEntity<String> delete(@RequestBody D entity) {
        service.delete(entity);
        return ResponseEntity.ok("Entity was deleted");
    }
}
