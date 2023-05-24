package com.example.sb.controller;

import com.example.sb.entity.Role;
import com.example.sb.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleService> {

    protected RoleController(RoleService service) {
        super(service);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Role>> showAll() {
        return super.showAll();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<Role> showById(@RequestParam("id") UUID id) {
        return super.showById(id);
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<Role> create(@RequestBody Role entity) {
        return super.create(entity);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<Role> update(@RequestBody Role entity) {
        return super.update(entity);
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Role> delete(@RequestBody Role entity) {
        return super.delete(entity);
    }
}
