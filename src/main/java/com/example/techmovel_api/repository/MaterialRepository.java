package com.example.techmovel_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techmovel_api.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    
}
