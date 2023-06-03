package com.example.sb.mapper.film;

import com.example.sb.dto.film.FilmDtoRequest;
import com.example.sb.dto.film.FilmDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.entity.Film;
import com.example.sb.mapper.CommonMapperResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FilmMapperResponse extends CommonMapperResponse<FilmDtoResponse, Film> {

    @Mapping(target = "directorIds",
            expression = "java(entity.getDirectorList() != null ? toDirectorIds(entity.getDirectorList()) : null)")
    @Override
    FilmDtoResponse toDto(Film entity);

        default List<UUID> toDirectorIds(List<Director> directors) {
        return directors.stream().map(Director::getId).collect(Collectors.toList());
    }


}
