package com.example.desafio.siad.domain.pessoa.endereco;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long cep;

    private String cidade;

    private String bairro;

    private String rua;

    //utilização de string pois em alguns locais o numero da residência pode ter uma letra. ex: 10A
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaFisica pessoa;

}
