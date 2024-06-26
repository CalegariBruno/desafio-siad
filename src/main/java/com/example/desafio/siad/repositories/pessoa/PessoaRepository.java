package com.example.desafio.siad.repositories.pessoa;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
