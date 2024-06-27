package com.example.desafio.siad.services;

import com.example.desafio.siad.domain.pessoa.Pessoa;
import com.example.desafio.siad.domain.pessoa.PessoaFisica;
import com.example.desafio.siad.domain.pessoa.PessoaJuridica;
import com.example.desafio.siad.dtos.PessoaFisicaDTO;
import com.example.desafio.siad.repositories.pessoa.PessoaFisicaRepository;
import com.example.desafio.siad.repositories.pessoa.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaFisica createPessoaFisica(PessoaFisicaDTO pessoa){
        PessoaFisica newPessoa = new PessoaFisica(pessoa);
        savePessoaFisica(newPessoa);
        return newPessoa;
    }

    public List<PessoaFisica> getAllUsers(){
        return this.pessoaFisicaRepository.findAll();
    }

    private void savePessoaFisica(PessoaFisica pessoa){
        pessoaFisicaRepository.save(pessoa);
    }

}
