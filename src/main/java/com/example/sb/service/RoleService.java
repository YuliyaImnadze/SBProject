package com.example.sb.service;

import com.example.sb.entity.Role;
import com.example.sb.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleService extends BaseService<Role, RoleRepository> {


    public RoleService(RoleRepository repository) {
        super(repository);
    }

    @Transactional
    @Override
    public Optional<Role> update(Role entity) {
        Role updated = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        updated.setTitle(entity.getTitle());
        updated.setDescription(entity.getTitle());
        updated.setUsersList(entity.getUsersList());
        return Optional.of(repository.save(updated));
    }
}
