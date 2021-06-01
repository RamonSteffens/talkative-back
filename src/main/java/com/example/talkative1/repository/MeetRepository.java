package com.example.talkative1.repository;

import com.example.talkative1.entity.meet.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetRepository extends JpaRepository<Meet, Integer> {

    List<Meet> findAllByActiveTrue();
}
