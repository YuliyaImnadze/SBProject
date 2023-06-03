package com.example.sb.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "sb_director")
public class Director extends BaseEntity {

    @Column(name = "director_fio")
    private String directorsFio;

    @Column(name = "position")
    private String position;

//    @JsonIgnoreProperties("directorList")
    @ManyToMany
    @JoinTable(name = "film_director",
            joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> filmList = new ArrayList<>();
//    private Set<Film> filmList;


}
