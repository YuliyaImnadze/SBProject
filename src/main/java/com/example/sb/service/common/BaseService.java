package com.example.sb.service.common;


import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.base.BaseEntityDtoResponse;
import com.example.sb.entity.BaseEntity;
import com.example.sb.mapper.CommonMapper;
import com.example.sb.repository.CommonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class BaseService<E extends BaseEntity,
        D extends BaseEntityDtoRequest, T extends BaseEntityDtoResponse,
        R extends CommonRepository<E>,
        M extends CommonMapper<E, D, T>>
        implements CommonService<E, D, T> {

    protected final R repository;
    protected final M mapper;



    public BaseService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<T> findAll() {
        List<E> listEntity = repository.findAll();
        return listEntity.stream().map(mapper::toDtoResponse).collect(Collectors.toList());
    }

    @Override
    public T findById(UUID id) throws EntityNotFoundException {
        E baseEntityById = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return mapper.toDtoResponse(baseEntityById);
    }

    @Transactional
    @Override
    public T save(D entity) throws DataIntegrityViolationException {
        E savedEntity = repository.save(mapper.toEntityRequest(entity));
        return mapper.toDtoResponse(savedEntity);
    }

    @Transactional
    @Override
    public T update(D entity) throws EntityNotFoundException {
        E updatedEntity = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        mapper.partialUpdateRequest(updatedEntity,entity);
        E savedEntity = repository.save(updatedEntity);
        return mapper.toDtoResponse(savedEntity);
    }


    @Transactional
    @Override
    public void delete(D entity) {
        repository.delete(mapper.toEntityRequest(entity));
    }

}
