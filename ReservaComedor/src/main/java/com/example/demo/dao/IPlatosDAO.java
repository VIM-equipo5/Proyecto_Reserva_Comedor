package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Platos;

public interface IPlatosDAO extends JpaRepository<Platos, Integer> {

}
