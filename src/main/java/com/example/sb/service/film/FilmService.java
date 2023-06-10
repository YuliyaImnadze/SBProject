package com.example.sb.service.film;

import com.example.sb.dto.film.FilmDtoResponse;

import java.util.UUID;

public interface FilmService {

    FilmDtoResponse addDirectorToFilm(UUID filmId, UUID directorId);

}
