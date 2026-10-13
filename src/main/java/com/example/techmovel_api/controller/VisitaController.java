package com.example.techmovel_api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techmovel_api.dto.VisitaRecord;
import com.example.techmovel_api.model.Escola;
import com.example.techmovel_api.model.Visita;
import com.example.techmovel_api.model.Voluntario;
import com.example.techmovel_api.repository.EscolaRepository;
import com.example.techmovel_api.repository.VisitaRepository;
import com.example.techmovel_api.repository.VoluntarioRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/visitas")
public class VisitaController {
    @Autowired 
    private EscolaRepository escolaRepository;

    @Autowired 
    private VisitaRepository visitaRepository;

    @Autowired 
    private VoluntarioRepository voluntarioRepository;

    @GetMapping("/buscar/allVisitas")
    public List<Visita> allVisitas() {
        return visitaRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Visita> visitasId(@PathVariable long id) {
        return visitaRepository.findById(id);
    }
    
    @GetMapping("/buscar/{dateTime}")
    public List<Visita> visitaData(@PathVariable LocalDateTime dateTime) {
        return visitaRepository.findByDataHora(dateTime);
    }
    
    @PostMapping("/agendar")
    public Visita registrarVisita(@RequestBody VisitaRecord dados) { // Data-Transfer Object
        Optional<Escola> opt_escola = escolaRepository.findById(dados.escolaId());
        Escola escola = opt_escola.get();
        List<Voluntario> voluntarios = voluntarioRepository.findAllById(dados.voluntariosId());

        Visita novaVisita = new Visita();
        novaVisita.setEscola(escola);
        novaVisita.setStatusVisita(dados.statusVisita());
        novaVisita.setDataHora(dados.dateTime());
        novaVisita.setVoluntarios(voluntarios);
        
        return visitaRepository.save(novaVisita);
    }

    @DeleteMapping("/delete/{visita_id}")
    public void deleteVisita(@PathVariable Long visita_id) {
        visitaRepository.deleteById(visita_id);;
    }
}
