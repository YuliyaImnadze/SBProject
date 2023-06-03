package com.example.sb.dto.role;

import com.example.sb.dto.BaseEntityDtoRequest;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
public class RoleDtoRequest extends BaseEntityDtoRequest implements Serializable {

    private String title;
    private String description;
//    List<UserDtoRequest> userList;

}