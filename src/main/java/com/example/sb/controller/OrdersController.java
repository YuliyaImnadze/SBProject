package com.example.sb.controller;

import com.example.sb.entity.Orders;
import com.example.sb.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController<Orders, OrdersService> {

    private final OrdersService ordersService;

    protected OrdersController(OrdersService service, OrdersService ordersService) {
        super(service);
        this.ordersService = ordersService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Orders>> showAll() {
        return super.showAll();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<Orders> showById(@RequestParam("id") UUID id) {
        return super.showById(id);
    }

    @PostMapping("/create") // он вообще нужен такой?? зачем тогда отдельно rent и buy (Взять фильм в аренду/купить)
    @Override
    public ResponseEntity<Orders> create(@RequestBody Orders entity) {
        return super.create(entity);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<Orders> update(@RequestBody Orders entity) {
        return super.update(entity);
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Orders> delete(@RequestBody Orders entity) {
        return super.delete(entity);
    }

    @PostMapping("/create/")
    public ResponseEntity<Orders> rentOrBuyFilm(@RequestParam("filmID") List<UUID> filmsID,
                                           @RequestParam("userId")  UUID userId,
                                           @RequestBody Orders order) {
        return ordersService.rentOrBuyFilm(filmsID, userId, order);
    }


}
