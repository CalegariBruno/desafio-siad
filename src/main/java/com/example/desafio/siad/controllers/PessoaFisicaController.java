package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.example.desafio.siad.services.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoaFisica(@RequestBody PessoaFisicaDTO pessoaFisicaDTO){
        Pessoa pessoa = pessoaService.createPessoa(pessoaFisicaDTO);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoaFisica(){
        List<Pessoa> pessoas = pessoaService.getAllPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable String id) {
        pessoaService.deletePessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
