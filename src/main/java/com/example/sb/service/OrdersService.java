package com.example.sb.service;

import com.example.sb.entity.Films;
import com.example.sb.entity.Orders;
import com.example.sb.entity.Users;
import com.example.sb.repository.FilmsRepository;
import com.example.sb.repository.OrdersRepository;
import com.example.sb.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdersService extends BaseService<Orders, OrdersRepository> {

    private final UsersRepository usersRepository;
    private final FilmsRepository filmsRepository;

    public OrdersService(OrdersRepository repository, UsersRepository usersRepository, FilmsRepository filmsRepository) {
        super(repository);
        this.usersRepository = usersRepository;
        this.filmsRepository = filmsRepository;
    }

    @Transactional
    @Override
    public Optional<Orders> update(Orders entity) {
        Orders updated = repository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        updated.setRentDate(entity.getRentDate());
        updated.setRentPeriod(entity.getRentPeriod());
        updated.setPurchase(entity.isPurchase());
        updated.setFilmList(entity.getFilmList());
        updated.setOwner(entity.getOwner());
        return Optional.of(repository.save(updated));
    }

    public ResponseEntity<Orders> rentOrBuyFilm(List<UUID> filmsId, UUID userId, Orders order) {
        List<Films> filmList = new ArrayList<>();
        order.setFilmList(filmList);
        for (UUID filmId : filmsId) {
            Films film = filmsRepository.findById(filmId)
                    .orElseThrow(() -> new EntityNotFoundException("Film not found"));
            order.getFilmList().add(film);
        }
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        order.setId(UUID.randomUUID());
        order.setRentPeriod(order.getRentPeriod());
        order.setPurchase(order.isPurchase());
        order.setOwner(user);
        repository.save(order);
        return ResponseEntity.ok(order);
    }



//    public ResponseEntity<Orders> rentFilm(List<UUID> filmsId, UUID userId, int rentPeriod) {
//        Orders order = new Orders();
//        for (UUID filmId : filmsId) {
//            Films film = filmsRepository.findById(filmId)
//                    .orElseThrow(() -> new EntityNotFoundException("Film not found"));
//            order.getFilmList().add(film);
//        }
//        Users user = usersRepository.findById(userId)
//                .orElseThrow(() -> new EntityNotFoundException("User not found"));
//        order.setRentDate(LocalDate.now());
//        order.setRentPeriod(rentPeriod);
//        order.setPurchase(false);
//        order.setOwner(user);
//        repository.save(order);
//        return ResponseEntity.ok(order);
//    }

    public ResponseEntity<Orders> buyFilm(List<UUID> filmsId, UUID userId) {
        Orders order = new Orders();
        for (UUID filmId : filmsId) {
            Films film = filmsRepository.findById(filmId)
                    .orElseThrow(() -> new EntityNotFoundException("Film not found"));
            order.getFilmList().add(film);
        }
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        order.setPurchase(true);
        order.setOwner(user);
        repository.save(order);
        return ResponseEntity.ok(order);
    }

}
