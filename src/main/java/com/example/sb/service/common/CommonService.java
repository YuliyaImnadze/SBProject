package com.example.sb.service.common;


import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.base.BaseEntityDtoResponse;
import com.example.sb.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface CommonService<E extends BaseEntity,
        D extends BaseEntityDtoRequest, T extends BaseEntityDtoResponse> {

    List<T> findAll();

    T findById(UUID id);

    T save(D entity);

    T update(D entity);

    void delete(D entity);


}
