package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Categoria;

public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}
