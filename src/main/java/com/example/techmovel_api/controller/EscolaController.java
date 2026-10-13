package com.example.techmovel_api.controller;

import com.example.techmovel_api.repository.EscolaRepository;
import com.example.techmovel_api.model.Escola;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/escola")
public class EscolaController {
    @Autowired // Para nao dar um new no repository
    private EscolaRepository escolaRepository;

    @PostMapping("/cadastrar")
    public Escola cadastrarEscola(@RequestBody Escola nova_escola) {
        return escolaRepository.save(nova_escola);
    }

    @GetMapping("busca/allEscolas")
    public List<Escola> buscarEscola() {
        return escolaRepository.findAll();
    }
    
    @GetMapping("busca/{id}")
    public Optional<Escola> buscarEscolaNome(@PathVariable Long id) {
        return escolaRepository.findById(id);
    }
    
    @GetMapping("/busca/{nome}")
    public List<Escola> getMethodName(@PathVariable String nome) {
        return escolaRepository.findByNome(nome);
    }

    @PutMapping("update/{id}")
    public void atualizarDadosEscola(@PathVariable Long id, @RequestBody Escola dadosNovosEscola) {
        Optional<Escola> old_escola = escolaRepository.findById(id);
        old_escola.get().setNome(dadosNovosEscola.getNome());
        old_escola.get().setEndereco(dadosNovosEscola.getEndereco());
        old_escola.get().setContatoDiretoria(dadosNovosEscola.getContatoDiretoria());

        escolaRepository.save(old_escola.get());
    }

    @DeleteMapping("delete/{id}")
    public void deletarEscola(@PathVariable Long id) {
        // TODO: Fazer uma verificação do ID (boa prática)
        escolaRepository.deleteById(id); 
    }
}
