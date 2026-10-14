package com.example.techmovel_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techmovel_api.dto.MaterialRecord;
import com.example.techmovel_api.model.Material;
import com.example.techmovel_api.repository.MaterialRepository;
import com.example.techmovel_api.repository.VisitaRepository;
import com.example.techmovel_api.service.MaterialService;
import com.example.techmovel_api.service.VisitaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/materiais")
@RestController
@RequiredArgsConstructor 
public class MaterialController {
    private MaterialService materialService;
    private VisitaService visitaService;

    @GetMapping("/allMateriais")
    public List<Material> allMateriais() {
        return materialService.allMateriais();
    }
    
    @PostMapping("adicionar")
    public List<Material> addMateriais(@RequestBody List<MaterialRecord> dadosMaterialRecord) {
        return materialService.addMateriais(dadosMaterialRecord);
    }
}
