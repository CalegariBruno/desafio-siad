package com.example.desafio.siad.repositories.pessoa;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {
}
