package com.example.techmovel_api.dto;

import com.example.techmovel_api.model.enums.StatusItem;

public record MaterialRecord(
    Long material_id,
    String nome_item,
    int quantidade,
    StatusItem statusItem,
    Long visita_id
) {}
