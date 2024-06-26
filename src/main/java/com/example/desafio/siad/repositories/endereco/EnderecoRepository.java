package com.example.desafio.siad.repositories.endereco;

import com.example.desafio.siad.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {
}
