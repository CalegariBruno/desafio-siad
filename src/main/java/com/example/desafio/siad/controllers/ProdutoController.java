package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaJuridica;
import com.example.desafio.siad.domain.produto.Produto;
import com.example.desafio.siad.dtos.ProdutoDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaRepository;
import com.example.desafio.siad.repositories.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private PessoaRepository juridicaRepository;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoDTO produtoDTO){

        Produto newProduto = new Produto();

        newProduto.setValor(produtoDTO.valor());
        newProduto.setNome(produtoDTO.nome());

        if (produtoDTO.pessoa()!=null){
            String pessoaId = produtoDTO.pessoa();
            Pessoa pessoa = juridicaRepository.findById(pessoaId)
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

            // Verificar se é uma PessoaFisica
            if (!(pessoa instanceof PessoaJuridica)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            newProduto.setPessoa((PessoaJuridica) pessoa);
        }

        repository.save(newProduto);
        return new ResponseEntity<>(newProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> produtos = repository.findAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        repository.delete(produto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
