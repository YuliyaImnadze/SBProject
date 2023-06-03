package com.example.sb.mapper.director;

import com.example.sb.dto.director.DirectorDtoRequest;
import com.example.sb.entity.Director;
import com.example.sb.mapper.CommonMapperRequest;
import org.mapstruct.*;
import org.springframework.stereotype.Component;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DirectorMapperRequest extends CommonMapperRequest<DirectorDtoRequest, Director> {

}

