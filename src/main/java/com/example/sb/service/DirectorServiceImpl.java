package com.example.sb.service;


import com.example.sb.dto.director.DirectorDtoRequest;
import com.example.sb.dto.director.DirectorDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.entity.Film;
import com.example.sb.mapper.director.DirectorMapperRequest;
import com.example.sb.mapper.director.DirectorMapperResponse;
import com.example.sb.repository.DirectorRepository;
import com.example.sb.repository.FilmsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service(value = "SB_DIRECTOR_SERVICE")
public class DirectorServiceImpl extends BaseService<Director,
        DirectorDtoRequest, DirectorDtoResponse,
        DirectorRepository,
        DirectorMapperRequest, DirectorMapperResponse> {

    private final FilmsRepository filmsRepository;


    public DirectorServiceImpl(DirectorRepository repository,
                               DirectorMapperRequest mapperRequest, DirectorMapperResponse mapperResponse,
                               FilmsRepository filmsRepository) {
        super(repository, mapperRequest, mapperResponse);
        this.filmsRepository = filmsRepository;
    }

    @Transactional
    @Override
    public DirectorDtoResponse update(DirectorDtoRequest entity) throws EntityNotFoundException {
        Director updatedEntity = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));
        mapperRequest.partialUpdate(updatedEntity,entity);
        Director savedEntity = repository.save(updatedEntity);
        return mapperResponse.toDto(savedEntity);
    }

    @Transactional
    public DirectorDtoResponse addFilmToDirector(UUID filmId, UUID directorId) {
        Film film = filmsRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException("Film not found"));
        Director director = repository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));
        List<Film> filmListEntity = director.getFilmList();
        if (!filmListEntity.contains(film)) {
            filmListEntity.add(film);
            repository.save(director);
            return mapperResponse.toDto(director);
        } else {
            throw new IllegalStateException("Film already exists in the film");
        }
    }


}
