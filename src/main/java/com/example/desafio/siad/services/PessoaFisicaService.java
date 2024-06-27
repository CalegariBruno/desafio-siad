package com.example.desafio.siad.services;

import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisica createPessoa(PessoaFisicaDTO pessoa){
        PessoaFisica newPessoa = new PessoaFisica(pessoa);
        savePessoa(newPessoa);
        return newPessoa;
    }

    public void deletePessoa(UUID id) {
        PessoaFisica pessoa = pessoaFisicaRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        pessoaFisicaRepository.delete(pessoa);
    }

    public List<PessoaFisica> getAllPessoas(){
        return this.pessoaFisicaRepository.findAll();
    }

    private void savePessoa(PessoaFisica pessoa){
        pessoaFisicaRepository.save(pessoa);
    }

}
