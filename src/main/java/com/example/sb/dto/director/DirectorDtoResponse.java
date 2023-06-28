package com.example.sb.dto.director;

import com.example.sb.dto.base.BaseEntityDtoResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class DirectorDtoResponse extends BaseEntityDtoResponse implements Serializable {

    private String directorsFio;
    private String position;
    private List<UUID> filmIds;

}
