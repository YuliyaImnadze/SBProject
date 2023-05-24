package com.example.sb.service;

import com.example.sb.entity.BaseEntity;
import com.example.sb.entity.Users;
import com.example.sb.repository.CommonRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<E extends BaseEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    protected final R repository;

//        @Autowired
    public BaseService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<E> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Optional<E> save(E entity) {
        return Optional.of(repository.save(entity));
    }

    @Transactional
    @Override
    public void delete(E entity) {
        repository.delete(entity);
    }
}
