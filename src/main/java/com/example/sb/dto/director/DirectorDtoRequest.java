package com.example.sb.dto.director;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Director}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DirectorDtoRequest extends BaseEntityDtoRequest implements Serializable {

    @Schema(description = "Фамилия Имя Отчество", example = "Тим Бертон")
    @Size(min = 5, max = 200, message = "The length of the directors FIO must be in the range from 5 to 200 characters")
    private String directorsFio;

    @Schema(description = "Должность", example = "Главный режиссер")
    private String position;



}