package com.example.desafio.siad.repositories.pessoa;

import com.example.desafio.siad.domain.pessoa.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, String> {
}
