package com.example.sb.mapper.film;

import com.example.sb.dto.film.FilmDtoRequest;
import com.example.sb.entity.Film;
import com.example.sb.mapper.CommonMapperRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FilmMapperRequest extends CommonMapperRequest<FilmDtoRequest, Film> {

}
