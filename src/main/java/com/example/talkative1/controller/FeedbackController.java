package com.example.talkative1.controller;

import com.example.talkative1.entity.feedback.request.CreateFeedbackRequest;
import com.example.talkative1.entity.feedback.response.FeedbackResponse;
import com.example.talkative1.service.CreateFeedbackService;
import com.example.talkative1.service.GetFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final CreateFeedbackService createFeedbackService;
    private final GetFeedbackService getFeedbackService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    private void save(@RequestBody final CreateFeedbackRequest request) {
        createFeedbackService.run(request);
    }

    @GetMapping("/received/{userId}")
    public List<FeedbackResponse> getReceivedFeedback(@PathVariable Integer userId) {
        return getFeedbackService.findAllByReceiverId(userId);
    }

    @GetMapping("/authored/{userId}")
    public List<FeedbackResponse> getAuthoredFeedback(@PathVariable Integer userId) {
        return getFeedbackService.findAllByAuthorId(userId);
    }

}
