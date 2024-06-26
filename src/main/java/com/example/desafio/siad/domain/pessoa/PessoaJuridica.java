package com.example.desafio.siad.domain.pessoa;

import com.example.desafio.siad.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaJuridica extends Pessoa {

    @JoinColumn(unique = true)
    private Long cnpj;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Produto> produtos;
}
