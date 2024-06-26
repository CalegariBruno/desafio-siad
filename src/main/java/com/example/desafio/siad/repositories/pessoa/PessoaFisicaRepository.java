package com.example.desafio.siad.repositories.pessoa;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
