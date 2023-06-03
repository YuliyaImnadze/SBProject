package com.example.sb.dto.film;

import com.example.sb.dto.BaseEntityDtoRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Film}
 */
@Data
public class FilmDtoRequest extends BaseEntityDtoRequest implements Serializable {

    private String title;
    private int premierYear;
    private String country;
    private String genre;

}