package com.example.sb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "sb_order")
public class Order extends BaseEntity {

    @CreatedDate
    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "rent_period")
    private int rentPeriod;

    @Column(name = "purchase")
    private boolean purchase;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Film> filmList;

}
