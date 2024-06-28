package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaJuridica;
import com.example.desafio.siad.dtos.PessoaJuridicaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody PessoaJuridicaDTO pessoaJuridicaDTO){
        Pessoa newPessoa = new PessoaJuridica(pessoaJuridicaDTO);
        repository.save(newPessoa);
        return new ResponseEntity<>(newPessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas(){
        List<Pessoa> pessoas = repository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable String id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        repository.delete(pessoa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
