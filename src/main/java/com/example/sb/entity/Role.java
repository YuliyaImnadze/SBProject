package com.example.sb.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sb_role")
public class Role extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role", cascade = {CascadeType.REMOVE, CascadeType.DETACH})
    // при удалении роли объекты Users связанные с этой ролью не будут удалены, данные останутся в базе
    private List<User> userList;

}
