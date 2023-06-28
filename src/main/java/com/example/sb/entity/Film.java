package com.example.sb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "SB_FILM")
@Table(name = "sb_film")
public class Film extends BaseEntity {

    @Column(nullable = false)
    @NotBlank(message = "The title field should not be empty")
    private String title;

    @Column(name = "premier_year")
    @Min(value = 1900)
    private int premierYear;

    @Column(name = "country")
    private String country;

    @Column(name = "genre")
    private String genre;

    @ManyToMany(mappedBy = "filmList")
    private List<Director> directorList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPremierYear() {
        return premierYear;
    }

    public void setPremierYear(int premierYear) {
        this.premierYear = premierYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Film film = (Film) o;
        return premierYear == film.premierYear && Objects.equals(title, film.title) && Objects.equals(country, film.country) && Objects.equals(genre, film.genre) && Objects.equals(directorList, film.directorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, premierYear, country, genre, directorList);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", premierYear=" + premierYear +
                ", country='" + country + '\'' +
                ", genre='" + genre + '\'' +
                ", directorList=" + directorList +
                '}';
    }
}
