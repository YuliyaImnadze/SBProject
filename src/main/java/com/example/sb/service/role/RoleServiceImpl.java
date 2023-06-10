package com.example.sb.service.role;

import com.example.sb.dto.role.RoleDtoRequest;
import com.example.sb.dto.role.RoleDtoResponse;
import com.example.sb.entity.Role;
import com.example.sb.mapper.RoleMapper;
import com.example.sb.repository.RoleRepository;
import com.example.sb.service.common.BaseService;
import org.springframework.stereotype.Service;


@Service(value = "SB_ROLE_SERVICE")
public class RoleServiceImpl extends BaseService<Role,
        RoleDtoRequest, RoleDtoResponse,
        RoleRepository,
        RoleMapper>
        implements RoleService {

    public RoleServiceImpl(RoleRepository repository,
                           RoleMapper mapper) {
        super(repository, mapper);
    }


}
