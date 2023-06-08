package com.example.sb.mapper.director;

import com.example.sb.dto.director.DirectorDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.mapper.CommonMapperResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.example.sb.entity.Film;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DirectorMapperResponse extends CommonMapperResponse<DirectorDtoResponse, Director> {

    @Mapping(target = "filmIds",
            expression = "java(entity.getFilmList() != null ? toFilmIds(entity.getFilmList()) : null)")
    @Override
    DirectorDtoResponse toDto(Director entity);

        default List<UUID> toFilmIds(List<Film> films) {
        return films.stream().map(Film::getId).collect(Collectors.toList());
    }

}
