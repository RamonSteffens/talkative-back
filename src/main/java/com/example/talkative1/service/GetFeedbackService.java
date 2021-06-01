package com.example.talkative1.service;

import com.example.talkative1.entity.feedback.Feedback;
import com.example.talkative1.entity.feedback.response.FeedbackResponse;
import com.example.talkative1.entity.meet.response.MeetResponse;
import com.example.talkative1.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFeedbackService {

    private final FeedbackRepository feedbackRepository;

    public List<FeedbackResponse> findAllByAuthorId(Integer authorId) {
        var feeds = feedbackRepository.findAllByAuthorId(authorId);
        var feedbackResponse = new ArrayList<FeedbackResponse>();
        feeds.forEach(feedback -> feedbackResponse.add(FeedbackResponse.build(feedback)));
        return feedbackResponse;
    }

    public List<FeedbackResponse> findAllByReceiverId(Integer receiverId) {
        var feeds = feedbackRepository.findAllByReceiverId(receiverId);
        var feedbackResponse = new ArrayList<FeedbackResponse>();
        feeds.forEach(feedback -> feedbackResponse.add(FeedbackResponse.build(feedback)));
        return feedbackResponse;
    }
}
