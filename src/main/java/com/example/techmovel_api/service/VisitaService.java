package com.example.techmovel_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.techmovel_api.dto.VisitaRecord;
import com.example.techmovel_api.model.Escola;
import com.example.techmovel_api.model.Material;
import com.example.techmovel_api.model.Visita;
import com.example.techmovel_api.model.Voluntario;
import com.example.techmovel_api.repository.EscolaRepository;
import com.example.techmovel_api.repository.MaterialRepository;
import com.example.techmovel_api.repository.VisitaRepository;
import com.example.techmovel_api.repository.VoluntarioRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class VisitaService {
    private VisitaRepository visitaRepository;
    private EscolaRepository escolaRepository;
    private VoluntarioRepository voluntarioRepository;
    private MaterialRepository materialRepository;

    @Transactional 
    public List<Visita> allVisitas() {
        return visitaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Visita> visitasId(long id) {
        return visitaRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Visita> visitaData(LocalDateTime dateTime) {
        return visitaRepository.findByDataHora(dateTime);
    }
    
    @Transactional(readOnly = true)
    public List<Voluntario> voluntariosListVisita(Long id) {
        var this_visita = visitaRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Não foi possível achar qualquer visita com o ID " + id)
        );
        return this_visita.getVoluntarios();
    }

    @Transactional(readOnly = true)
    public List<Material> visitaMateriais(Long id) {
        var visita = visitaRepository.findById(id).get();
        return visita.getMateriais();
    }

    @Transactional
    public Visita registrarVisita(VisitaRecord dados) { // Data-Transfer Object
        List<Voluntario> this_voluntarios = voluntarioRepository.findAllById(dados.voluntariosId());
        List<Material> this_materiais = materialRepository.findAllById(dados.materiaisId());
        Escola this_escola = escolaRepository.findById(dados.escolaId()).orElseThrow(
            () -> new RuntimeException("Não foi possível achar qualquer visita com o ID" + dados.escolaId()));
        Visita this_visita = new Visita();

        this_visita.setDataHora(dados.dateTime());
        this_visita.setEscola(this_escola);
        this_visita.setVoluntarios(this_voluntarios);
        this_visita.setStatusVisita(dados.statusVisita());
        this_visita.setMateriais(this_materiais);

        return visitaRepository.save(this_visita);

    }

    @Transactional
    public void deleteVisita(Long visita_id) {
        visitaRepository.deleteById(visita_id);;
    }
}
