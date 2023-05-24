package com.example.sb.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "role", cascade = {CascadeType.REMOVE, CascadeType.DETACH})
    // при удалении роли объекты Users связанные с этой ролью не будут удалены, данные останутся в базе
    private List<Users> usersList;

}
