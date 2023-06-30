package com.example.sb.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "SB_ORDER")
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

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Film> filmList = new ArrayList<>();

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public int getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(int rentPeriod) {
        this.rentPeriod = rentPeriod;
    }

    public boolean isPurchase() {
        return purchase;
    }

    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
        Order order = (Order) o;
        return rentPeriod == order.rentPeriod && purchase == order.purchase && Objects.equals(rentDate, order.rentDate) && Objects.equals(owner, order.owner) && Objects.equals(filmList, order.filmList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rentDate, rentPeriod, purchase, owner, filmList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "rentDate=" + rentDate +
                ", rentPeriod=" + rentPeriod +
                ", purchase=" + purchase +
                ", owner=" + owner +
                ", filmList=" + filmList +
                '}';
    }
}
