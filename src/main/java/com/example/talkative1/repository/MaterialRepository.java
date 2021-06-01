package com.example.talkative1.repository;

import com.example.talkative1.entity.material.Material;
import com.example.talkative1.entity.material.response.MaterialTitleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    Optional<Material> findByTitle(String title);

    List<Material> findByTopic(String topic);

    @Query("SELECT id, title FROM Material")
    List<MaterialTitleResponse> findAllMaterialNames();
}
