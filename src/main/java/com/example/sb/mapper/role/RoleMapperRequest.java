package com.example.sb.mapper.role;

import com.example.sb.dto.role.RoleDtoRequest;
import com.example.sb.entity.Role;
import com.example.sb.mapper.CommonMapperRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapperRequest extends CommonMapperRequest<RoleDtoRequest, Role> {
}
