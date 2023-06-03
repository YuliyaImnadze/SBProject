package com.example.sb.mapper.role;

import com.example.sb.dto.role.RoleDtoResponse;
import com.example.sb.entity.Role;
import com.example.sb.mapper.CommonMapperResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapperResponse extends CommonMapperResponse<RoleDtoResponse, Role> {
}
