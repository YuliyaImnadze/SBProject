package com.example.sb.repository;

import com.example.sb.entity.Directors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DirectorsRepository extends CommonRepository<Directors> {


}