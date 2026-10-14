package com.example.techmovel_api.dto;

import com.example.techmovel_api.model.enums.AreaDeAtuacao;
import com.example.techmovel_api.model.enums.VoluntarioCapitulo;

public record VoluntarioRecord (
    String nome,
    Long id,
    AreaDeAtuacao area_de_atuacao,
    VoluntarioCapitulo voluntarioCapitulo
) {}
