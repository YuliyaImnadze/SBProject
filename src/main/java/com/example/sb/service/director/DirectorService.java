package com.example.sb.service.director;

import com.example.sb.dto.director.DirectorDtoRequest;
import com.example.sb.dto.director.DirectorDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.service.common.CommonService;

import java.util.UUID;

public interface DirectorService extends CommonService<Director, DirectorDtoRequest, DirectorDtoResponse> {

    DirectorDtoResponse addFilmToDirector(UUID filmId, UUID directorId);
}
