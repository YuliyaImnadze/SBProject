package com.example.sb.entity;


import jakarta.persistence.*;

import java.util.Objects;


@Entity(name = "SB_ROLE")
@Table(name = "sb_role")
public class Role extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return Objects.equals(title, role.title) && Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, description);
    }

    @Override
    public String toString() {
        return "Role{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
