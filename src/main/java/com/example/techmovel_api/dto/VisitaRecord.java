package com.example.techmovel_api.dto;

import com.example.techmovel_api.model.enums.*;

import java.util.List;
import java.time.LocalDateTime;

public record VisitaRecord (
    LocalDateTime dateTime,
    StatusVisita statusVisita,
    Long escolaId,
    List<Long> voluntariosId,
    List<Long> materiaisId
) {}
