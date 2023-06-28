package com.example.sb.dto.role;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDtoRequest extends BaseEntityDtoRequest implements Serializable {

    private String title;
    private String description;

}
