package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.domain.pessoa.PessoaJuridica;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.example.desafio.siad.dtos.PessoaJuridicaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaRepository repository;

    @PostMapping
    public ResponseEntity<PessoaJuridica> createPessoa(@RequestBody PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridica newPessoa = new PessoaJuridica(pessoaJuridicaDTO);
        repository.save(newPessoa);
        return new ResponseEntity<>(newPessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaJuridica>> getAllPessoas(){
        List<PessoaJuridica> pessoas = repository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable String id) {
        PessoaJuridica pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        repository.delete(pessoa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridica> updatePessoaFisica(@PathVariable String id, @RequestBody PessoaJuridicaDTO pessoaJuridicaDTO) {

        // Buscar a pessoa pelo ID
        PessoaJuridica pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(pessoaJuridicaDTO.nome());
        pessoa.setDataNascimento(pessoaJuridicaDTO.dataNascimento());
        pessoa.setCnpj(pessoaJuridicaDTO.cnpj());

        repository.save(pessoa);

        return  new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

}
