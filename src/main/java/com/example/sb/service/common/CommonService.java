package com.example.sb.service.common;


import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.base.BaseEntityDtoResponse;
import com.example.sb.entity.BaseEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.UUID;

public interface CommonService<E extends BaseEntity,
        D extends BaseEntityDtoRequest, T extends BaseEntityDtoResponse> {

    List<T> findAll();

    T findById(UUID id) throws EntityNotFoundException;

    T save(D entity) throws DataIntegrityViolationException;

    T update(D entity) throws EntityNotFoundException;

    void delete(D entity); // здесь нужна ошибка? какая? общая?


}
