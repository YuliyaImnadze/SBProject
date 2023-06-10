package com.example.sb.dto.order;

import com.example.sb.dto.base.BaseEntityDtoResponse;
import com.example.sb.dto.film.FilmDtoResponse;
import com.example.sb.dto.user.UserDtoResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDtoResponse  extends BaseEntityDtoResponse implements Serializable {

    private int rentPeriod;
    private boolean purchase;
    private UserDtoResponse owner;
    private List<FilmDtoResponse> filmList;

}
