package com.example.desafio.siad.domain.pessoa;

import com.example.desafio.siad.domain.produto.Produto;
import com.example.desafio.siad.dtos.PessoaJuridicaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pessoa_juridica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaJuridica extends Pessoa {

    @JoinColumn(unique = true)
    private String cnpj;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<Produto> produtos;

    public PessoaJuridica(PessoaJuridicaDTO pessoaJuridica) {
        this.setNome(pessoaJuridica.nome());
        this.setDataNascimento(pessoaJuridica.dataNascimento());
        this.cnpj = pessoaJuridica.cnpj();
    }
}
