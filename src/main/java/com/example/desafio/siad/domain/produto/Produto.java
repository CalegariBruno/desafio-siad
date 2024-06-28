package com.example.desafio.siad.domain.produto;

import com.example.desafio.siad.domain.pessoa.PessoaJuridica;
import com.example.desafio.siad.domain.venda.Venda;
import com.example.desafio.siad.dtos.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Double valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    private PessoaJuridica pessoa;

    @JsonIgnore
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private List<Venda> vendas;

}
