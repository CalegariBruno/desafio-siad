package com.example.desafio.siad.dtos;

import java.time.LocalDate;

public record PessoaJuridicaDTO(String nome, LocalDate dataNascimento, String cnpj) {
}
