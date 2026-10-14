package com.example.techmovel_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.techmovel_api.dto.EscolaRecord;
import com.example.techmovel_api.model.Escola;
import com.example.techmovel_api.repository.EscolaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class EscolaService {
    private EscolaRepository escolaRepository;

    @Transactional 
    public Escola cadastrarEscola(EscolaRecord nova_escola) {
        Escola escola = new Escola();
        escola.setNome(nova_escola.nome());
        escola.setEndereco(nova_escola.endereco());
        escola.setContatoDiretoria(nova_escola.contatoDiretoria());

        return escolaRepository.save(escola);
    }

    @Transactional(readOnly = true)
    public List<Escola> buscarEscola() {
        return escolaRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Escola> buscarEscolaId(Long id) {
        return escolaRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Escola> buscarEscolaNome(String nome) {
        return escolaRepository.findByNome(nome);
    }

    @Transactional 
    public Escola atualizarDadosEscola(Long id, EscolaRecord dadosNovosEscola) {
        var old_escola = escolaRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Escola não encontrada com o ID : " + id));
        old_escola.setNome(dadosNovosEscola.nome());
        old_escola.setEndereco(dadosNovosEscola.endereco());
        old_escola.setContatoDiretoria(dadosNovosEscola.contatoDiretoria());

        return escolaRepository.save(old_escola);
    }

    @Transactional 
    public void deletarEscola(Long id) {
        escolaRepository.deleteById(id); 
    }
}
