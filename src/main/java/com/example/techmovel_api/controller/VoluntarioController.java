package com.example.techmovel_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techmovel_api.model.Voluntario;
import com.example.techmovel_api.repository.VoluntarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RequestMapping("/voluntarios")
@RestController 
public class VoluntarioController {
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @PostMapping("/cadastro")
    public Voluntario cadastrarVoluntario(@RequestBody Voluntario novo_voluntario) {
        return voluntarioRepository.save(novo_voluntario);
    }
    
    @GetMapping("/allVoluntarios")
    public List<Voluntario> allVoluntarios() {
        return voluntarioRepository.findAll();
    }

    @GetMapping("/buscar/{nome}")
    public List<Voluntario> buscarNomeVoluntario(@PathVariable String nome_voluntario) {
        return voluntarioRepository.findByNome(nome_voluntario);
    }
    
    
}
