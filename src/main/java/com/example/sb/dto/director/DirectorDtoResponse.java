package com.example.sb.dto.director;

import com.example.sb.dto.BaseEntityDtoResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class DirectorDtoResponse extends BaseEntityDtoResponse implements Serializable {

    private String directorsFio;
    private String position;
    private List<UUID> filmIds;

}
