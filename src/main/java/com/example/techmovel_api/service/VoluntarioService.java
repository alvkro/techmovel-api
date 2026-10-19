package com.example.techmovel_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.techmovel_api.dto.VoluntarioRecord;
import com.example.techmovel_api.model.Voluntario;
import com.example.techmovel_api.repository.VoluntarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    @Transactional 
    public Voluntario cadastrarVoluntario(VoluntarioRecord novo_voluntario) {
        Voluntario voluntario = new Voluntario();
        voluntario.setNome(novo_voluntario.nome());
        voluntario.setCapitulo(novo_voluntario.voluntarioCapitulo());
        voluntario.setArea_de_atuacao(novo_voluntario.area_de_atuacao());

        return voluntarioRepository.save(voluntario);
    }
    
    @Transactional(readOnly = true)
    public List<Voluntario> allVoluntarios() {
        return voluntarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Voluntario> buscarNomeVoluntario(String nome_voluntario) {
        return voluntarioRepository.findByNome(nome_voluntario);
    }
    
    @Transactional(readOnly = true)
    public Optional<Voluntario> buscarIdVoluntario(@PathVariable Long id) {
        return voluntarioRepository.findById(id);
    }
    
    @Transactional 
    public Voluntario atualizarVoluntario(Long id, VoluntarioRecord voluntario_info_nova) {
        var this_voluntario = voluntarioRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Voluntario não encontrada com o ID : \" + id"));
        this_voluntario.setNome(voluntario_info_nova.nome());
        this_voluntario.setCapitulo(voluntario_info_nova.voluntarioCapitulo());
        this_voluntario.setArea_de_atuacao(voluntario_info_nova.area_de_atuacao());

        return voluntarioRepository.save(this_voluntario);
    }

    @Transactional 
    public void deletarVoluntario(Long id) {
        voluntarioRepository.deleteById(id);
    }
}
