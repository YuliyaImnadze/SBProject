package com.example.sb.service.director;

import com.example.sb.dto.director.DirectorDtoResponse;

import java.util.UUID;

public interface DirectorService {

    DirectorDtoResponse addFilmToDirector(UUID filmId, UUID directorId);
}
