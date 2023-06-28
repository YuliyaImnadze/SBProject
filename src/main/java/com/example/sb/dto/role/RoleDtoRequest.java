package com.example.sb.dto.role;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDtoRequest extends BaseEntityDtoRequest {

    private String title;
    private String description;

}
