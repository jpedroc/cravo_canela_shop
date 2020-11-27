package com.example.CravoCanela.repositorio;

import com.example.CravoCanela.dominio.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepositorio extends JpaRepository<Imagem,Long> {
}
