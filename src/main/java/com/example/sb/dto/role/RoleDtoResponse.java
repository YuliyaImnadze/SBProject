package com.example.sb.dto.role;

import com.example.sb.dto.base.BaseEntityDtoResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Role}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDtoResponse  extends BaseEntityDtoResponse implements Serializable {

    private String title;
    private String description;


}