package com.example.desafio.siad.dtos;

import com.example.desafio.siad.domain.endereco.Endereco;

import java.time.LocalDate;
import java.util.List;

public record PessoaFisicaDTO(String nome, LocalDate dataNascimento, String cpf, List<Endereco> enderecos) {
}
