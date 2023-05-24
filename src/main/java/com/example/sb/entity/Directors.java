package com.example.sb.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "directors")
public class Directors extends BaseEntity {

    @Column(name = "directors_fio")
    private String directorsFio;

    @Column
    private String position;

    @JsonIgnore
//    @JsonIdentityReference(alwaysAsId = true) // потом проверить когда нибудь
    @ManyToMany
    @JoinTable(name = "film_directors",
            joinColumns = @JoinColumn(name = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<Films> filmsList = new ArrayList<>();

}
