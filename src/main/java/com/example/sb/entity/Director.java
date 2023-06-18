package com.example.sb.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sb_director")
public class Director extends BaseEntity {

    @Column(name = "director_fio")
    private String directorsFio;

    @Column(name = "position")
    private String position;

    //    @JsonIgnoreProperties("directorList") - использовала, чтобы исключить рекурсию при выводе без ДТО
    @ManyToMany
    @JoinTable(name = "film_director",
            joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> filmList = new ArrayList<>();

    public String getDirectorsFio() {
        return directorsFio;
    }

    public void setDirectorsFio(String directorsFio) {
        this.directorsFio = directorsFio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Director director = (Director) o;
        return Objects.equals(directorsFio, director.directorsFio) && Objects.equals(position, director.position) && Objects.equals(filmList, director.filmList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), directorsFio, position, filmList);
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorsFio='" + directorsFio + '\'' +
                ", position='" + position + '\'' +
                ", filmList=" + filmList +
                '}';
    }
}
