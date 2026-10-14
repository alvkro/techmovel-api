package com.example.techmovel_api.model;

import com.example.techmovel_api.model.enums.StatusItem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity 
@Data
@Table(name = "materiais")
public class Material {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @NotBlank 
    private String nome_item;

    @Column
    @NotNull
    private int quantidade;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusItem statusItem;

    @ManyToOne
    @JoinColumn(name = "visita_id")
    private Visita visita;
}
