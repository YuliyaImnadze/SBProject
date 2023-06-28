package com.example.sb.mapper;

import com.example.sb.dto.film.FilmDtoRequest;
import com.example.sb.dto.film.FilmDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FilmMapper extends CommonMapper<Film, FilmDtoRequest, FilmDtoResponse> {

    @Mapping(target = "directorIds",
            expression = "java(entity.getDirectorList() != null ? toDirectorIds(entity.getDirectorList()) : null)")
    @Override
    FilmDtoResponse toDtoResponse(Film entity);

    default List<UUID> toDirectorIds(List<Director> directors) {
        return directors.stream()
                .map(Director::getId)
                .collect(Collectors.toList());
    }

}
