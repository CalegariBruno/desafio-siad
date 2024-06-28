package com.example.desafio.siad.domain.endereco;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.dtos.EnderecoDTO;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    private PessoaFisica pessoa;

    public Endereco(EnderecoDTO endereco, PessoaFisica pessoa) {
        this.cep = endereco.cep();
        this.bairro = endereco.bairro();
        this.rua = endereco.rua();
        this.cidade = endereco.cidade();
        this.numero = endereco.numero();
        this.pessoa = pessoa;
    }
}
