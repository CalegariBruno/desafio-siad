package com.example.desafio.siad.repositories.produto;

import com.example.desafio.siad.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
