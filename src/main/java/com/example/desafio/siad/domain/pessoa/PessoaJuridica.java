package com.example.desafio.siad.domain.pessoa;

import com.example.desafio.siad.domain.produto.Produto;
import com.example.desafio.siad.dtos.PessoaJuridicaDTO;
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

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    public PessoaJuridica(PessoaJuridicaDTO pessoaJuridica) {
        this.setNome(pessoaJuridica.nome());
        this.setDataNascimento(pessoaJuridica.dataNascimento());
        this.setCnpj(pessoaJuridica.cnpj());
    }
}
