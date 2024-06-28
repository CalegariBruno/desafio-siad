package com.example.desafio.siad.controllers;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.domain.produto.Produto;
import com.example.desafio.siad.domain.venda.Venda;
import com.example.desafio.siad.dtos.VendaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaRepository;
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
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Venda> createVenda(@RequestBody VendaDTO vendaDTO) {

        // Buscar a pessoa pelo ID
        String pessoaId = vendaDTO.pessoa();
        Pessoa pessoa = pessoaRepository.findById(String.valueOf(pessoaId))
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        // Verificar se é uma PessoaFisica
        if (!(pessoa instanceof PessoaFisica)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Buscar a produto pelo ID
        Integer produtoId = vendaDTO.produto();
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrada"));

        Venda newVenda = new Venda();

        newVenda.setQuantidade(vendaDTO.quantidade());
        newVenda.setPessoa((PessoaFisica) pessoa);
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

}
