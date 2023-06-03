package com.example.sb.dto.order;

import com.example.sb.dto.BaseEntityDtoRequest;
import com.example.sb.dto.film.FilmDtoRequest;
import com.example.sb.dto.user.UserDtoRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.example.sb.entity.Order}
 */
@Data
public class OrderDtoRequest extends BaseEntityDtoRequest implements Serializable {

    private int rentPeriod;
    private boolean purchase;
}