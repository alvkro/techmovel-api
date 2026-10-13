package com.example.techmovel_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.techmovel_api.model.Voluntario;
import java.util.List;


@Repository 
public interface VoluntarioRepository extends JpaRepository <Voluntario, Long>{
    List<Voluntario> findByNome(String nome);
}
