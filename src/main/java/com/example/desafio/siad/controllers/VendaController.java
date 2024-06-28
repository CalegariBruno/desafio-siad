package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.domain.produto.Produto;
import com.example.desafio.siad.domain.venda.Venda;
import com.example.desafio.siad.dtos.VendaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaFisicaRepository;
import com.example.desafio.siad.repositories.produto.ProdutoRepository;
import com.example.desafio.siad.repositories.venda.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("venda")
public class VendaController {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PessoaFisicaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Venda> createVenda(@RequestBody VendaDTO vendaDTO) {

        // Buscar a pessoa pelo ID
        String pessoaId = vendaDTO.pessoa();
        PessoaFisica pessoa = pessoaRepository.findById(String.valueOf(pessoaId))
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        // Buscar a produto pelo ID
        Integer produtoId = vendaDTO.produto();
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Venda newVenda = new Venda();

        newVenda.setQuantidade(vendaDTO.quantidade());
        newVenda.setPessoa(pessoa);
        newVenda.setProduto(produto);

        newVenda.setTotal( newVenda.getQuantidade() * newVenda.getProduto().getValor() );

        repository.save(newVenda);
        return new ResponseEntity<>(newVenda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> getAllVendas(){
        List<Venda> vendas = repository.findAll();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenda(@PathVariable Integer id) {
        Venda venda = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        repository.delete(venda);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> updateVenda(@PathVariable Integer id, @RequestBody VendaDTO vendaDTO) {

        // Buscar a venda existente pelo ID
        Venda venda = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        // Buscar a pessoa física pelo ID do DTO
        PessoaFisica pessoaFisica = pessoaRepository.findById(vendaDTO.pessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        // Buscar o produto pelo ID do DTO
        Produto produto = produtoRepository.findById(vendaDTO.produto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        venda.setQuantidade(vendaDTO.quantidade());
        venda.setPessoa(pessoaFisica);
        venda.setProduto(produto);

        venda.setTotal( venda.getQuantidade() * venda.getProduto().getValor() );

        repository.save(venda);
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

}
