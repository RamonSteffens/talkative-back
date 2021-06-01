package com.example.talkative1.repository;


import com.example.talkative1.entity.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    List<Feedback> findAllByAuthorId(Integer authorId);

    List<Feedback> findAllByReceiverId(Integer receiverId);


}
