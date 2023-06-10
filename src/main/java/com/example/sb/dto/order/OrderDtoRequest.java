package com.example.sb.dto.order;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Order}
 */
@Data
public class OrderDtoRequest extends BaseEntityDtoRequest implements Serializable {

    private int rentPeriod;
    private boolean purchase;
}