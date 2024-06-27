package com.example.desafio.siad.domain.pessoa;

import com.example.desafio.siad.domain.endereco.Endereco;
import com.example.desafio.siad.domain.venda.Venda;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pessoa_fisica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisica extends Pessoa{

    @JoinColumn(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Venda> vendas;

    public PessoaFisica(PessoaFisicaDTO pessoaFisica) {
        this.setNome(pessoaFisica.nome());
        this.setDataNascimento(pessoaFisica.dataNascimento());
        this.setCpf(pessoaFisica.cpf());
    }
}
