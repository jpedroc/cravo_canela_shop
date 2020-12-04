package com.example.cravocanela.repositorio;

import com.example.cravocanela.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Long>, JpaSpecificationExecutor<Produto> {
}
