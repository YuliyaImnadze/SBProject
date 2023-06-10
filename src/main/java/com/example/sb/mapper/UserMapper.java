package com.example.sb.mapper;

import com.example.sb.dto.user.UserDtoRequest;
import com.example.sb.dto.user.UserDtoResponse;
import com.example.sb.entity.User;
import com.example.sb.mapper.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper extends CommonMapper<User, UserDtoRequest, UserDtoResponse> {
}
