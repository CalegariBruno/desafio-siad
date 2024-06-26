package com.example.desafio.siad.domain.pessoa;

import com.example.desafio.siad.domain.pessoa.endereco.Endereco;
import com.example.desafio.siad.domain.venda.Venda;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisica extends Pessoa{

    @JoinColumn(unique = true)
    private Long cpf;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Venda> vendas;
}
