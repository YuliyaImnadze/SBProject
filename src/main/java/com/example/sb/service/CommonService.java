package com.example.sb.service;

import com.example.sb.entity.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommonService<E extends BaseEntity> {

    List<E> findAll();

    Optional<E> findById(UUID id);

    Optional<E> save(E entity);

    Optional<E> update(E entity);

    void delete(E entity);


}
