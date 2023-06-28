package com.example.sb.controller.common;


import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.base.BaseEntityDtoResponse;
import com.example.sb.dto.BaseResponse;
import com.example.sb.entity.BaseEntity;
import com.example.sb.service.common.CommonService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.UUID;


public abstract class BaseController<E extends BaseEntity,
        D extends BaseEntityDtoRequest, T extends BaseEntityDtoResponse,
        S extends CommonService<E, D, T>>
        implements CommonController<D, T> {

    protected final S service;

    protected BaseController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<T>> showAll() {
        List<T> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<BaseResponse<T>> showById(@RequestParam UUID id) {
            T byId = service.findById(id);
            BaseResponse<T> tBaseResponse = new BaseResponse<>(HttpStatus.OK, byId);
            return ResponseEntity.ok(tBaseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse<T>> create(@RequestBody @Valid D entity) {
            T saved = service.save(entity);
            BaseResponse<T> tBaseResponse = new BaseResponse<>(HttpStatus.OK, saved);
            return ResponseEntity.ok(tBaseResponse);
    }


    @Override
    public ResponseEntity<BaseResponse<T>> update(@RequestBody @Valid D entity) {
            T updated = service.update(entity);
            BaseResponse<T> tBaseResponse = new BaseResponse<>(HttpStatus.OK, updated);
            return ResponseEntity.ok(tBaseResponse);
    }

    @Hidden
    @Override
    public ResponseEntity<String> delete(@RequestBody D entity) {
        service.delete(entity);
        return ResponseEntity.ok("Entity was deleted");
    }
}
