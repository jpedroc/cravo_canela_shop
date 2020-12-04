package com.example.cravocanela.repositorio;

import com.example.cravocanela.dominio.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepositorio extends JpaRepository<Imagem,Long> {
}
