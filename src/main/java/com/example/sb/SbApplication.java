package com.example.sb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PutMapping;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
public class SbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SbApplication.class, args);
    }



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
