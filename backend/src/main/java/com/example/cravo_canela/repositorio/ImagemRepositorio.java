package com.example.cravo_canela.repositorio;

import com.example.cravo_canela.dominio.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepositorio extends JpaRepository<Imagem,Long> {
}
