package com.example.desafio.siad.repositories.venda;

import com.example.desafio.siad.domain.venda.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
