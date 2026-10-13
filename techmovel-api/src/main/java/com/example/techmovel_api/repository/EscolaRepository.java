package com.example.techmovel_api.repository;
import com.example.techmovel_api.*;
import com.example.techmovel_api.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository 
public interface EscolaRepository extends JpaRepository<Escola, Long> {
    List<Escola> findByNome(String nome);
}
