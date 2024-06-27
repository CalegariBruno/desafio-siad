package com.example.desafio.siad.dtos;

import java.time.LocalDate;

public record PessoaFisicaDTO(String nome, LocalDate dataNascimento, String cpf) {
}
