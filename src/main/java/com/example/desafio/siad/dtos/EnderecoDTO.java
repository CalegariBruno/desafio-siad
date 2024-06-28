package com.example.desafio.siad.dtos;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;

import java.util.UUID;

public record EnderecoDTO(Long cep , String cidade, String bairro, String rua, String numero, String pessoa) {

}
