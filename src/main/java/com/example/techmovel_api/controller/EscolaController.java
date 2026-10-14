package com.example.techmovel_api.controller;

import com.example.techmovel_api.service.EscolaService;

import lombok.RequiredArgsConstructor;

import com.example.techmovel_api.dto.EscolaRecord;
import com.example.techmovel_api.model.Escola;
import java.util.*;

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
@RequiredArgsConstructor 
public class EscolaController {
    private EscolaService escolaService;

    @PostMapping("/cadastrar")
    public Escola cadastrarEscola(@RequestBody EscolaRecord nova_escola) {
        return escolaService.cadastrarEscola(nova_escola);
    }

    @GetMapping("allEscolas")
    public List<Escola> buscarEscola() {
        return escolaService.buscarEscola();
    }
    
    @GetMapping("{id}")
    public Optional<Escola> buscarEscolaId(@PathVariable Long id) {
        return escolaService.buscarEscolaId(id);
    }
    
    @GetMapping("/{nome}")
    public List<Escola> buscarEscolaNome(@PathVariable String nome) {
        return escolaService.buscarEscolaNome(nome);
    }

    @PutMapping("update/{id}")
    public void atualizarDadosEscola(@PathVariable Long id, @RequestBody EscolaRecord dadosNovosEscola) {
        escolaService.atualizarDadosEscola(id, dadosNovosEscola);
    }

    @DeleteMapping("delete/{id}")
    public void deletarEscola(@PathVariable Long id) {
        escolaService.deletarEscola(id);
    }
}
