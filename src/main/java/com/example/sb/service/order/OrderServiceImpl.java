package com.example.sb.service.order;

import com.example.sb.dto.order.OrderDtoRequest;
import com.example.sb.dto.order.OrderDtoResponse;
import com.example.sb.entity.Film;
import com.example.sb.entity.Order;
import com.example.sb.entity.User;
import com.example.sb.mapper.OrderMapper;
import com.example.sb.repository.FilmsRepository;
import com.example.sb.repository.OrderRepository;
import com.example.sb.repository.UserRepository;
import com.example.sb.service.common.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service(value = "SB_ORDER_SERVICE")
public class OrderServiceImpl extends BaseService<Order,
        OrderDtoRequest, OrderDtoResponse,
        OrderRepository,
        OrderMapper>
        implements OrderService {

    private final UserRepository userRepository;
    private final FilmsRepository filmsRepository;

    public OrderServiceImpl(OrderRepository repository,
                            OrderMapper mapper,
                            UserRepository userRepository,
                            FilmsRepository filmsRepository) {
        super(repository, mapper);
        this.userRepository = userRepository;
        this.filmsRepository = filmsRepository;
    }


    @Transactional
    @Override
    public OrderDtoResponse rentOrBuyFilm(List<UUID> filmsId, UUID userId, OrderDtoRequest orderDto)
            throws EntityNotFoundException {
        Order order = mapper.toEntityRequest(orderDto);
        order.setFilmList(order.getFilmList());
        for (UUID filmId : filmsId) {
            Film film = filmsRepository.findById(filmId)
                    .orElseThrow(() -> new EntityNotFoundException("Film not found"));
            order.getFilmList().add(film);
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        order.setId(UUID.randomUUID());
        order.setOwner(user);
        Order savedEntity = repository.save(order);
        return mapper.toDtoResponse(savedEntity);
    }


}
