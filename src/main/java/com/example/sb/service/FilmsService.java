package com.example.sb.service;

import com.example.sb.entity.Directors;
import com.example.sb.entity.Films;
import com.example.sb.entity.Users;
import com.example.sb.repository.FilmsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmsService extends BaseService<Films, FilmsRepository> {


    public FilmsService(FilmsRepository repository) {
        super(repository);
    }

    @Transactional
    @Override
    public Optional<Films> update(Films entity) {
        Films updated = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Film not found"));
        updated.setTitle(entity.getTitle());
        updated.setPremierYear(entity.getPremierYear());
        updated.setCountry(entity.getCountry());
        updated.setGenre(entity.getGenre());
        updated.setDirectorsList(entity.getDirectorsList());
        return Optional.of(repository.save(updated));
    }





}
