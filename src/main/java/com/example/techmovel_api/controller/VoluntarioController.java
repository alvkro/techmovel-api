package com.example.techmovel_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techmovel_api.dto.VoluntarioRecord;
import com.example.techmovel_api.model.Voluntario;
import com.example.techmovel_api.service.VoluntarioService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/voluntarios")
@RestController 
@RequiredArgsConstructor 
public class VoluntarioController {
    private final VoluntarioService voluntarioService;

    @PostMapping("/cadastro")
    public Voluntario cadastrarVoluntario(@RequestBody VoluntarioRecord novo_voluntario) {
        return voluntarioService.cadastrarVoluntario(novo_voluntario);
    }
    
    @GetMapping("/allVoluntarios")
    public List<Voluntario> allVoluntarios() {
        return voluntarioService.allVoluntarios();
    }

    @GetMapping("/{nome_voluntario}")
    public List<Voluntario> buscarNomeVoluntario(@PathVariable String nome_voluntario) {
        return voluntarioService.buscarNomeVoluntario(nome_voluntario);
    }
    
    @GetMapping("/{id}")
    public Optional<Voluntario> buscarIdVoluntario(@PathVariable Long id) {
        return voluntarioService.buscarIdVoluntario(id);
    }
    
    @PutMapping("update/{id}")
    public void atualizarVoluntario(@PathVariable Long id, @RequestBody VoluntarioRecord voluntario_info_nova) {
       voluntarioService.atualizarVoluntario(id, voluntario_info_nova);
    }

    @DeleteMapping ("/delete/{id}")
    public void deletarVoluntario(@PathVariable Long id) {
        voluntarioService.deletarVoluntario(id);
    }
}
