package com.example.sb.dto.film;

import com.example.sb.dto.base.BaseEntityDtoResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class FilmDtoResponse extends BaseEntityDtoResponse implements Serializable {

    private String title;
    private int premierYear;
    private String country;
    private String genre;
    private List<UUID> directorIds;

}
