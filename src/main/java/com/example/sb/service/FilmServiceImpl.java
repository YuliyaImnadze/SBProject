package com.example.sb.service;

import com.example.sb.dto.film.FilmDtoRequest;
import com.example.sb.dto.film.FilmDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.entity.Film;
import com.example.sb.mapper.film.FilmMapperRequest;
import com.example.sb.mapper.film.FilmMapperResponse;
import com.example.sb.repository.DirectorRepository;
import com.example.sb.repository.FilmsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service(value = "SB_FILM_SERVICE")
public class FilmServiceImpl extends BaseService<Film,
        FilmDtoRequest, FilmDtoResponse,
        FilmsRepository,
        FilmMapperRequest, FilmMapperResponse> {

    private final DirectorRepository directorRepository;


    public FilmServiceImpl(FilmsRepository repository,
                           FilmMapperRequest mapperRequest, FilmMapperResponse mapperResponse,
                           DirectorRepository directorRepository) {
        super(repository, mapperRequest, mapperResponse);
        this.directorRepository = directorRepository;
    }


    @Transactional
    public FilmDtoResponse addDirectorToFilm(UUID filmId, UUID directorId) {
        Film film = repository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException("Film not found"));
        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));
        List<Director> directorList = film.getDirectorList();
//        Set<Director> directorList = film.getDirectorList();
        if (!directorList.contains(director)) {
            directorList.add(director);
            director.getFilmList().add(film);
            repository.save(film);
            return mapperResponse.toDto(film);
        } else {
            throw new IllegalStateException("Director already exists in the film");
        }
    }


}
