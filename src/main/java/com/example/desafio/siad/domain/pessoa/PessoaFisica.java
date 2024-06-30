package com.example.desafio.siad.domain.pessoa;

import com.example.desafio.siad.domain.endereco.Endereco;
import com.example.desafio.siad.domain.venda.Venda;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "pessoa_fisica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisica extends Pessoa{

    @JoinColumn(unique = true)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<Venda> vendas;

    public PessoaFisica(PessoaFisicaDTO pessoaFisica) {
        this.setNome(pessoaFisica.nome());
        this.setDataNascimento(pessoaFisica.dataNascimento());
        this.cpf = pessoaFisica.cpf();
        this.enderecos = pessoaFisica.enderecos().stream().map(
                dto -> {
                    Endereco endereco = new Endereco();
                    endereco.setCep(dto.getCep());
                    endereco.setNumero(dto.getNumero());
                    endereco.setBairro(dto.getBairro());
                    endereco.setRua(dto.getRua());
                    endereco.setCidade(dto.getCidade());
                    endereco.setPessoa(this);
                    return endereco;
                }).collect(Collectors.toList());
    }
}
