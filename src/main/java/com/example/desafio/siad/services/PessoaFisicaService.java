package com.example.desafio.siad.services;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaRepository pessoaFisicaRepository;

    public Pessoa createPessoa(PessoaFisicaDTO pessoa){
        Pessoa newPessoa = new PessoaFisica(pessoa);
        savePessoa(newPessoa);
        return newPessoa;
    }

    public void deletePessoa(String id) {
        Pessoa pessoa = pessoaFisicaRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        pessoaFisicaRepository.delete(pessoa);
    }

    public List<Pessoa> getAllPessoas(){
        return this.pessoaFisicaRepository.findAll();
    }

    private void savePessoa(Pessoa pessoa){
        pessoaFisicaRepository.save(pessoa);
    }

}
