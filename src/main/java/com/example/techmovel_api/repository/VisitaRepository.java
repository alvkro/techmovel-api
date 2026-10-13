package com.example.techmovel_api.repository;

import com.example.techmovel_api.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;


@Repository 
public interface VisitaRepository extends JpaRepository<Visita, Long> {
    List<Visita> findByDataHora(LocalDateTime dataHora);
}
