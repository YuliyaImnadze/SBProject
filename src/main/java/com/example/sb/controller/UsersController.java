package com.example.sb.controller;

import com.example.sb.entity.Orders;
import com.example.sb.entity.Users;
import com.example.sb.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController extends BaseController<Users, UsersService> {

    private final UsersService usersService;

    protected UsersController(UsersService service, UsersService usersService) {
        super(service);
        this.usersService = usersService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Users>> showAll() {
        return super.showAll();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<Users> showById(@RequestParam("id") UUID id) {
        return super.showById(id);
    }

    @PostMapping("/create") // переделать (из-за createdWhen
    @Override
    public ResponseEntity<Users> create(@RequestBody Users entity) {
        return super.create(entity);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<Users> update(@RequestBody Users entity) {
        return super.update(entity);
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Users> delete(@RequestBody Users entity) {
        return super.delete(entity);
    }


    @GetMapping("/orders/")
    public ResponseEntity<List<Orders>> allUserOrders(@RequestParam("id") UUID id) {
        return usersService.allOrders(id);
    }

}
