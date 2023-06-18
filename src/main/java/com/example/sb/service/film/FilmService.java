package com.example.sb.service.film;

import com.example.sb.dto.film.FilmDtoRequest;
import com.example.sb.dto.film.FilmDtoResponse;
import com.example.sb.entity.Film;
import com.example.sb.service.common.CommonService;

import java.util.UUID;

public interface FilmService extends CommonService<Film, FilmDtoRequest, FilmDtoResponse> {

    FilmDtoResponse addDirectorToFilm(UUID filmId, UUID directorId);

}
