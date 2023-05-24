package com.example.sb.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "films")
public class Films extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(name = "premier_year")
    private int premierYear;

    @Column
    private String country;

    @Column
    private String genre;

    @JsonIgnore
//    @JsonIdentityReference(alwaysAsId = true)
    @ManyToMany(mappedBy = "filmsList")
    private List<Directors> directorsList;

}
