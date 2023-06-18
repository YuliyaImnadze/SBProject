package com.example.sb.service.director;


import com.example.sb.dto.director.DirectorDtoRequest;
import com.example.sb.dto.director.DirectorDtoResponse;
import com.example.sb.entity.Director;
import com.example.sb.entity.Film;
import com.example.sb.mapper.DirectorMapper;
import com.example.sb.repository.DirectorRepository;
import com.example.sb.repository.FilmsRepository;
import com.example.sb.service.common.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service(value = "SB_DIRECTOR_SERVICE")
public class DirectorServiceImpl extends BaseService<Director,
        DirectorDtoRequest, DirectorDtoResponse,
        DirectorRepository,
        DirectorMapper>
        implements DirectorService {

    private final FilmsRepository filmsRepository;


    public DirectorServiceImpl(DirectorRepository repository,
                               DirectorMapper mapper,
                               FilmsRepository filmsRepository) {
        super(repository, mapper);
        this.filmsRepository = filmsRepository;
    }

    @Transactional
    @Override
    public DirectorDtoResponse addFilmToDirector(UUID filmId, UUID directorId) {
        Film film = filmsRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException("Film not found"));
        Director director = repository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));
        List<Film> filmListEntity = director.getFilmList();
        if (!filmListEntity.contains(film)) {
            filmListEntity.add(film);
            repository.save(director);
            return mapper.toDtoResponse(director);
        } else {
            throw new IllegalStateException("Film already exists in the film");
        }
    }


}
