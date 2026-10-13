package com.example.techmovel_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techmovel_api.model.Voluntario;
import com.example.techmovel_api.repository.VoluntarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/voluntarios")
@RestController 
public class VoluntarioController {
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @PostMapping("/cadastro")
    public Voluntario cadastrarVoluntario(@RequestBody Voluntario novo_voluntario) {
        return voluntarioRepository.save(novo_voluntario);
    }
    
    @GetMapping("buscar/allVoluntarios")
    public List<Voluntario> allVoluntarios() {
        return voluntarioRepository.findAll();
    }

    @GetMapping("/buscar/{nome}")
    public List<Voluntario> buscarNomeVoluntario(@PathVariable String nome_voluntario) {
        return voluntarioRepository.findByNome(nome_voluntario);
    }
    
    @GetMapping("/buscar/{id}")
    public Optional<Voluntario> buscarIdVoluntario(@PathVariable Long id) {
        return voluntarioRepository.findById(id);
    }
    
    @PutMapping("update/{id}")
    public void atualizarVoluntario(@PathVariable Long id, @RequestBody Voluntario voluntario_info_nova) {
        Optional<Voluntario> old_voluntario = voluntarioRepository.findById(id);
        Voluntario m_old_voluntario = old_voluntario.get();

        m_old_voluntario.setNome(voluntario_info_nova.getNome());
        m_old_voluntario.setCapitulo(voluntario_info_nova.getCapitulo());
        m_old_voluntario.setArea_de_atuacao(voluntario_info_nova.getArea_de_atuacao());
    }

    @DeleteMapping ("/delete/{id}")
    public void deletarVoluntario(@PathVariable Long id) {
        voluntarioRepository.deleteById(id);
    }
}
