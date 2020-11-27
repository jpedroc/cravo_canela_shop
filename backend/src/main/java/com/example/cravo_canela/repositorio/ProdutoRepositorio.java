package com.example.cravo_canela.repositorio;

import com.example.cravo_canela.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
    Optional<List<Produto>> findByStatus(int i);
}
