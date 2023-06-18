package com.example.sb.controller.film;

import com.example.sb.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RequestMapping("/films")
public interface FilmController {

    @PutMapping("/add_director/")
    ResponseEntity<BaseResponse<?>> addDirector(@RequestParam("directorId") UUID directorID,
                                                @RequestParam("filmId") UUID filmId);

}
