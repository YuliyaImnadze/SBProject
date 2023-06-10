package com.example.sb.dto.director;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Director}
 */
@Data
public class DirectorDtoRequest extends BaseEntityDtoRequest implements Serializable {

    @Schema(description = "Фамилия Имя Отчество", example = "Тим Бертон")
    private String directorsFio;
    private String position;

}