package com.example.sb.mapper.order;

import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.entity.Order;
import com.example.sb.mapper.CommonMapperResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapperResponse extends CommonMapperResponse<OrderDtoResponse, Order> {
}
