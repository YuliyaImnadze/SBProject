package com.example.sb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "sb_film")
public class Film extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(name = "premier_year")
    private int premierYear;

    @Column(name = "country")
    private String country;

    @Column(name = "genre")
    private String genre;

//    @JsonIgnoreProperties("filmList")
    @ManyToMany(mappedBy = "filmList")
    private List<Director> directorList = new ArrayList<>();
//    private Set<Director> directorList;

}
