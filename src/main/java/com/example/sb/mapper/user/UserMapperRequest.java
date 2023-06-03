package com.example.sb.mapper.user;

import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.entity.User;
import com.example.sb.mapper.CommonMapperRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapperRequest extends CommonMapperRequest<UserDtoRequest, User> {
}
