package com.example.desafio.siad.domain.venda;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.domain.produto.Produto;
import com.example.desafio.siad.dtos.ProdutoDTO;
import com.example.desafio.siad.dtos.VendaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double total;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaFisica pessoa;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Venda (VendaDTO dto, PessoaFisica pessoa, Produto produto){
        this.total = dto.total();
        this.quantidade = dto.quantidade();
        this.pessoa = pessoa;
        this.produto = produto;
    }

}
