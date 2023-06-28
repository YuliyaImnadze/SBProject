package com.example.sb.dto.film;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Film}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FilmDtoRequest extends BaseEntityDtoRequest implements Serializable {

    @NotBlank(message = "The title field should not be empty")
    private String title;

    @Min(value = 1900)
    private int premierYear;

    private String country;

    private String genre;

}