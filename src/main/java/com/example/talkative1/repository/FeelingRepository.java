package com.example.talkative1.repository;

import com.example.talkative1.entity.feeling.Feeling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeelingRepository extends JpaRepository<Feeling, Integer> {
}
