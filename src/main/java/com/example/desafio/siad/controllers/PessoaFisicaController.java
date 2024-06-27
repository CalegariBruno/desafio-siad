package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaFisicaRepository;
import com.example.desafio.siad.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaFisica> createPessoaFisica(@RequestBody PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoa = pessoaService.createPessoaFisica(pessoaFisicaDTO);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaFisica>> getAllPessoaFisica(){
        List<PessoaFisica> pessoas = pessoaService.getAllUsers();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

}
