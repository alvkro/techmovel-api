package com.example.techmovel_api.controller;
import com.example.techmovel_api.service.VisitaService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techmovel_api.dto.VisitaRecord;
import com.example.techmovel_api.model.Material;
import com.example.techmovel_api.model.Visita;
import com.example.techmovel_api.model.Voluntario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/visitas")
@RequiredArgsConstructor 
public class VisitaController {
    private final VisitaService visitaService;

    @GetMapping("/allVisitas")
    public List<Visita> allVisitas() {
        return visitaService.allVisitas();
    }

    @GetMapping("/{id}")
    public Optional<Visita> visitasId(@PathVariable long id) {
        return visitaService.visitasId(id);
    }
    
    @GetMapping("/{dateTime}")
    public List<Visita> visitaData(@PathVariable LocalDateTime dateTime) {
        return visitaService.visitaData(dateTime);
    }
    
    @GetMapping("/{id}/voluntarios")
    public List<Voluntario> voluntariosListVisita(@PathVariable Long id) {
        return visitaService.voluntariosListVisita(id);
    }

    @GetMapping("/{id}/materiais")
    public List<Material> visitaMateriais(@PathVariable Long id) {
        return visitaService.visitaMateriais(id);
    }

    @PostMapping("/agendar")
    public Visita registrarVisita(@RequestBody VisitaRecord dados) { // Data-Transfer Object
        return visitaService.registrarVisita(dados);
    }

    @DeleteMapping("/delete/{visita_id}")
    public void deleteVisita(@PathVariable Long visita_id) {
        visitaService.deleteVisita(visita_id);
    }
}
