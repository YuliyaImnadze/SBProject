package com.example.sb.mapper.order;

import com.example.sb.dto.order.OrderDtoRequest;
import com.example.sb.entity.Order;
import com.example.sb.mapper.CommonMapperRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapperRequest extends CommonMapperRequest<OrderDtoRequest, Order> {
}
