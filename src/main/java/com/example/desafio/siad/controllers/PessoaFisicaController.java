package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.endereco.Endereco;
import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository repository;

    private EnderecoController enderecoController;

    @PostMapping
    public ResponseEntity<PessoaFisica> createPessoa(@RequestBody PessoaFisicaDTO pessoaDTO){
        PessoaFisica newPessoa = new PessoaFisica(pessoaDTO);
        repository.save(newPessoa);
        return new ResponseEntity<>(newPessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaFisica>> getAllPessoas(){
        List<PessoaFisica> pessoas = repository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable String id) {
        PessoaFisica pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        repository.delete(pessoa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaFisica> updatePessoa(@PathVariable String id, @RequestBody PessoaFisicaDTO pessoaFisicaDTO) {

        // Buscar a pessoa pelo ID
        PessoaFisica pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(pessoaFisicaDTO.nome());
        pessoa.setDataNascimento(pessoaFisicaDTO.dataNascimento());
        pessoa.setCpf(pessoaFisicaDTO.cpf());

        pessoa.getEnderecos().clear();
        pessoa.setEnderecos(pessoaFisicaDTO.enderecos().stream().map(dto -> {
            Endereco endereco = new Endereco();
            endereco.setRua(dto.getRua());
            endereco.setCidade(dto.getCidade());
            endereco.setPessoa(pessoa);
            return endereco;
        }).collect(Collectors.toList()));

        repository.save(pessoa);

        return  new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

}
