package com.example.sb.controller.director;

import com.example.sb.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RequestMapping("/directors")
public interface DirectorController {

    @PutMapping("/add_film/")
    ResponseEntity<BaseResponse<?>> addFilm(@RequestParam("directorId") UUID directorID,
                                            @RequestParam("filmId") UUID filmId);

}
