package com.example.sb;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.director.DirectorDtoResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@SpringBootApplication
public class SbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SbApplication.class, args);
    }

    // CustomPasswordEncoder - нужен ли или просто
    // @Bean
    //    public PasswordEncoder getPasswordEncoder() {
    //        return new BCryptPasswordEncoder();
    //    }


    // как сделать, чтобы не была null
    // @CreatedDate
    //    @Column(name = "created_when")
    //    private LocalDate createdWhen;

    // по структуре - куда девать конфиг, tokenController и пр

    // public interface CommonController< D extends BaseEntityDtoRequest, // E extends BaseEntity - можно убрать?

    //    @PutMapping("/add_film/") - куда писать в интерфейс или контроллер

    //     @SecurityRequirement(name = "JWT") - как делать


    // так много и должно быть?
//    @Override
//    public ResponseEntity<BaseResponse<?>> addFilm(@RequestParam("directorId") UUID directorID,
//                                                   @RequestParam("filmId") UUID filmId) {
//        try {
//            DirectorDtoResponse directorDtoResponse = directorServiceImpl.addFilmToDirector(filmId, directorID);
//            BaseResponse<DirectorDtoResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, directorDtoResponse, LocalDateTime.now());
//            return ResponseEntity.ok(tBaseResponse);
//        } catch (EntityNotFoundException | IllegalStateException e) {
//            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now());
//            return ResponseEntity.ok(tBaseResponse);
//        }
//    }


    @Override
    public void run(String... args) throws Exception {

//        // Создание генератора случайных чисел
//        SecureRandom secureRandom = new SecureRandom();
//
//        // Определение длины случайной строки
//        int length = 32; // Пример: 32 символа
//
//        // Создание массива байтов для хранения случайной последовательности
//        byte[] randomBytes = new byte[length];
//
//        // Заполнение массива случайными значениями
//        secureRandom.nextBytes(randomBytes);
//
//        // Кодирование массива байтов в строку Base64
//        String randomString = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
//        System.out.println("Случайная строка: " + randomString);

    }


}
