package com.example.techmovel_api.repository;

import com.example.techmovel_api.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDateTime;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
    List<Visita> findByDataHora(LocalDateTime dataHora);
}
