package com.example.sb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "SB_DIRECTOR")
@Table(name = "sb_director")
public class Director extends BaseEntity {

    @Column(name = "director_fio")
    @Size(min = 5, max = 200, message = "The length of the directors FIO must be in the range from 5 to 200 characters")
    private String directorsFio;

    @Column(name = "position")
    private String position;

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
