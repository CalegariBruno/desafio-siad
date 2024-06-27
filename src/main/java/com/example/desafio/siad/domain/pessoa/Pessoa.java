package com.example.desafio.siad.domain.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "pessoa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    @JoinColumn(name = "data_nascimento")
    private LocalDate dataNascimento;

}
