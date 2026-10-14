package com.example.techmovel_api.repository;
import com.example.techmovel_api.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
    List<Escola> findByNome(String nome);
}
