package com.example.sb.service;

import com.example.sb.entity.Directors;
import com.example.sb.entity.Films;
import com.example.sb.repository.DirectorsRepository;
import com.example.sb.repository.FilmsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service(value = "SB_DIRECTOR_SERVICE") // ResponseEntity только в контроллер
public class DirectorsService extends BaseService<Directors, DirectorsRepository> {

    private final FilmsRepository filmsRepository;

    public DirectorsService(DirectorsRepository repository, FilmsRepository filmsRepository) {
        super(repository);
        this.filmsRepository = filmsRepository;
    }

        @Transactional // что repository.save(updated)?
        @Override
    public Optional<Directors> update(Directors entity) {
        Directors updated = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));
        updated.setDirectorsFio(entity.getDirectorsFio());
        updated.setPosition(entity.getPosition());
        updated.setFilmsList(entity.getFilmsList());
        return Optional.of(repository.save(updated));
    }

    @Transactional
    public ResponseEntity<Directors> addFilmToDirector(UUID directorId, Films film) {
        Directors director = repository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));
       return addFilmToDirector(director, film);
    }


    @Transactional
    public ResponseEntity<Directors> addDirectorToFilm(UUID filmId, Directors director) { // Эдвард руки ножницы, Тим Бертон
        Films film = filmsRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException("Film not found")); // нашла. нужно проверить нет ли там такого режиссера
        return addFilmToDirector(director, film);
    }

    @Transactional
    public ResponseEntity<Directors> addFilmToDirector(Directors director, Films film) {
        List<Films> directorFilmsList = director.getFilmsList();
        if (!directorFilmsList.contains(film)) {
            directorFilmsList.add(film);
            update(director);
            return ResponseEntity.ok(director);
        } else {
            throw new IllegalStateException("Director already exists in the film");
        }
    }

}
