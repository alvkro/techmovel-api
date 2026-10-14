package com.example.techmovel_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.techmovel_api.dto.MaterialRecord;
import com.example.techmovel_api.model.Material;
import com.example.techmovel_api.repository.MaterialRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class MaterialService {
    private MaterialRepository materialRepository;

    @Transactional(readOnly = true)
    public List<Material> allMateriais() {
        return materialRepository.findAll();
    }

    @Transactional 
    public List<Material> addMateriais(List<MaterialRecord> dadosMaterialRecord) {
        List<Material> novosMateriais = new ArrayList<>();

        for (MaterialRecord idxMaterialRecord : dadosMaterialRecord) {
            Material material = new Material();
            material.setNome_item(idxMaterialRecord.nome_item());
            material.setQuantidade(idxMaterialRecord.quantidade());
            material.setStatusItem(idxMaterialRecord.statusItem());
        }
        return materialRepository.saveAll(novosMateriais);
    }

    @Transactional(readOnly = true)
    public int materialIdQuantidade(MaterialRecord materialRecord) {
        var this_material = materialRepository.findById(materialRecord.material_id()).orElseThrow(
        () -> new RuntimeException("Não foi possível achar o material com ID " + materialRecord.material_id())
        );
        return this_material.getQuantidade();
    }

    @Transactional 
    public void removerMateriais() {
        //* Da para fazer com quantidade, pelo body...
        //  */
    }
}
