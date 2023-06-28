package com.example.sb.dto.order;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * DTO for {@link com.example.sb.entity.Order}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDtoRequest extends BaseEntityDtoRequest {

    private int rentPeriod;
    private boolean purchase;

}