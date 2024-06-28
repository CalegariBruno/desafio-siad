package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.endereco.Endereco;
import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.dtos.EnderecoDTO;
import com.example.desafio.siad.repositories.endereco.EnderecoRepository;
import com.example.desafio.siad.repositories.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private PessoaRepository fisicaRepository;

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody EnderecoDTO enderecoDTO){

        Endereco newEndereco = new Endereco();

        newEndereco.setBairro(enderecoDTO.bairro());
        newEndereco.setCep(enderecoDTO.cep());
        newEndereco.setNumero(enderecoDTO.numero());
        newEndereco.setCidade(enderecoDTO.cidade());
        newEndereco.setRua(enderecoDTO.rua());

        if (enderecoDTO.pessoa()!=null){
            String pessoaId = enderecoDTO.pessoa();
            Pessoa pessoa = fisicaRepository.findById(pessoaId)
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

            // Verificar se é uma PessoaFisica
            if (!(pessoa instanceof PessoaFisica)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            newEndereco.setPessoa((PessoaFisica) pessoa);
        }

        repository.save(newEndereco);

        return new ResponseEntity<>(newEndereco, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEndereco(){
        List<Endereco> enderecos = repository.findAll();
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Integer id) {
        Endereco endereco = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        repository.delete(endereco);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
