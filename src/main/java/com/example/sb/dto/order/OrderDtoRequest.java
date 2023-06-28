package com.example.sb.dto.order;

import com.example.sb.dto.base.BaseEntityDtoRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * DTO for {@link com.example.sb.entity.Order}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDtoRequest extends BaseEntityDtoRequest implements Serializable {

    private int rentPeriod;
    private boolean purchase;

}