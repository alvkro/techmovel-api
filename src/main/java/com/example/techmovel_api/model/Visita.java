package com.example.techmovel_api.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.techmovel_api.model.enums.StatusVisita;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "visitas")
@Getter
@Setter
public class Visita {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column 
    private StatusVisita statusVisita;

    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola escola;

    @ManyToMany
    @JoinTable(
        name = "visita_voluntario",                        // 1. Nome da nova tabela no Postgres
        joinColumns = @JoinColumn(name = "visita_id"),     // 2. Coluna dessa tabela que aponta para MIM (Visita)
        inverseJoinColumns = @JoinColumn(name = "voluntario_id") // 3. Coluna dessa tabela que aponta pro OUTRO LADO (Voluntario)
    )
    private List<Voluntario> voluntarios = new ArrayList(); // Safety-convert
}
