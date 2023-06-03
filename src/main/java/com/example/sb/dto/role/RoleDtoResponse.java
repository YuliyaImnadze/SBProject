package com.example.sb.dto.role;

import com.example.sb.dto.BaseEntityDtoResponse;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Role}
 */
@Data
public class RoleDtoResponse  extends BaseEntityDtoResponse implements Serializable {

    private String title;
    private String description;
//    List<UserDtoResponse> userList;

}