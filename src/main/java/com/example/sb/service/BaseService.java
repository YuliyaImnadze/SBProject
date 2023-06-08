package com.example.sb.service;


import com.example.sb.dto.BaseEntityDtoRequest;
import com.example.sb.dto.BaseEntityDtoResponse;
import com.example.sb.dto.director.DirectorDtoRequest;
import com.example.sb.dto.director.DirectorDtoResponse;
import com.example.sb.entity.BaseEntity;
import com.example.sb.entity.Director;
import com.example.sb.mapper.CommonMapperRequest;
import com.example.sb.mapper.CommonMapperResponse;
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
        MR extends CommonMapperRequest<D, E>, MRR extends CommonMapperResponse<T, E>>
        implements CommonService<E, D, T> {

    protected final R repository;
    protected final MR mapperRequest;
    protected final MRR mapperResponse;


    public BaseService(R repository, MR mapperRequest, MRR mapperResponse) {
        this.repository = repository;
        this.mapperRequest = mapperRequest;
        this.mapperResponse = mapperResponse;
    }


    @Override
    public List<T> findAll() {
        List<E> listEntity = repository.findAll();
        return listEntity.stream().map(mapperResponse::toDto).collect(Collectors.toList());
    }

    @Override
    public T findById(UUID id) throws EntityNotFoundException {
        E baseEntityById = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return mapperResponse.toDto(baseEntityById);
    }

    @Transactional
    @Override
    public T save(D entity) throws DataIntegrityViolationException {
        E savedEntity = repository.save(mapperRequest.toEntity(entity));
        return mapperResponse.toDto(savedEntity);
    }

    @Transactional
    @Override
    public T update(D entity) throws EntityNotFoundException {
        E updatedEntity = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        mapperRequest.partialUpdate(updatedEntity,entity);
        E savedEntity = repository.save(updatedEntity);
        return mapperResponse.toDto(savedEntity);
    }


    @Transactional
    @Override
    public void delete(D entity) {
        repository.delete(mapperRequest.toEntity(entity));
    }

}
