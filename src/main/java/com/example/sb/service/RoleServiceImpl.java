package com.example.sb.service;

import com.example.sb.dto.role.RoleDtoRequest;
import com.example.sb.dto.role.RoleDtoResponse;
import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.entity.Role;
import com.example.sb.entity.User;
import com.example.sb.mapper.role.RoleMapperRequest;
import com.example.sb.mapper.role.RoleMapperResponse;
import com.example.sb.mapper.user.UserMapperRequest;
import com.example.sb.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service(value = "SB_ROLE_SERVICE")
public class RoleServiceImpl extends BaseService<Role,
        RoleDtoRequest, RoleDtoResponse,
        RoleRepository,
        RoleMapperRequest, RoleMapperResponse> {

    public RoleServiceImpl(RoleRepository repository,
                           RoleMapperRequest mapperRequest, RoleMapperResponse mapperResponse) {
        super(repository, mapperRequest, mapperResponse);
    }

    @Transactional
    @Override
    public RoleDtoResponse update(RoleDtoRequest entity) throws EntityNotFoundException {
        Role updated = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        updated.setTitle(entity.getTitle());
        updated.setDescription(entity.getTitle());
//        List<UserDtoRequest> userListDto = entity.getUserList();
//        List<User> userListEntity = userMapperRequest.toEntity(userListDto);
//        updated.setUserList(userListEntity);
        Role savedEntity = repository.save(updated);
        return mapperResponse.toDto(savedEntity);
    }


}
