package com.example.sb.mapper;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.base.BaseEntityDtoResponse;
import com.example.sb.entity.BaseEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


public interface CommonMapper<E extends BaseEntity,
        D extends BaseEntityDtoRequest, T extends BaseEntityDtoResponse> {

    E toEntityRequest(D dto);
    E toEntityResponse(T dto);

    D toDtoRequest(E entity);
    T toDtoResponse(E entity);

    List<T> toDtoResponse(List<E> entityList);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdateRequest(@MappingTarget E entity, D dto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdateResponse(@MappingTarget E entity, T dto);

}