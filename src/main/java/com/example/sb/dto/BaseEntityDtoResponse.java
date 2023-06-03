package com.example.sb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public abstract class BaseEntityDtoResponse {
    @Schema(description = "Идентификатор", example = "93d63437-8a6d-42d6-bf1e-d3f04582521e")
    private UUID id;

}
