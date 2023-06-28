package com.example.sb.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public abstract class BaseEntityDtoRequest implements Serializable {
    @Schema(description = "Идентификатор", example = "93d63437-8a6d-42d6-bf1e-d3f04582521e")
    private UUID id;
}
