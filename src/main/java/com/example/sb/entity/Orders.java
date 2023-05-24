package com.example.sb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {

    @CreatedDate
    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "rent_period")
    private int rentPeriod;

    @Column
    private boolean purchase;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users owner;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Films> filmList;

}
