package com.example.sb.controller;

import com.example.sb.entity.BaseEntity;
import com.example.sb.service.CommonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.UUID;

public abstract class BaseController<E extends BaseEntity, S extends CommonService<E>>
        implements CommonController<E> {

    private final S service;
    protected BaseController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<E>> showAll() {
        List<E> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<E> showById(@RequestParam UUID id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    @Override
    public ResponseEntity<E> create(@RequestBody E entity) {
        return service.save(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new DataIntegrityViolationException("Failed to save entity"));
    }


    @Override
    public ResponseEntity<E> update(E entity) {
        return service.update(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new DataIntegrityViolationException("Failed to save entity"));
    }

    @Override
    public ResponseEntity<E> delete(@RequestBody E entity) {
        service.delete(entity);
        return ResponseEntity.ok().build();
    }
}
