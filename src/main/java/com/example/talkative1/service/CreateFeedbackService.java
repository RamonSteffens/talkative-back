package com.example.talkative1.service;

import com.example.talkative1.entity.feedback.Feedback;
import com.example.talkative1.entity.feedback.request.CreateFeedbackRequest;
import com.example.talkative1.entity.user.User;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.FeedbackRepository;
import com.example.talkative1.service.meet.GetMeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateFeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final GetMeetService getMeetService;

    public void run(CreateFeedbackRequest request){
        var meetId = request.getMeetId();
        var authorId = request.getAuthorId();

        var meet = getMeetService.findById(meetId);
        var userCreator = meet.getUserCreator();
        var userPartner = meet.getUserPartner();
        validUsers(userPartner, userCreator);

        User authorUser;
        User receiverUser;
        if (authorId.equals(userCreator.getId())){
            authorUser = userCreator;
            receiverUser = userPartner;
        }else{
            authorUser = userPartner;
            receiverUser = userCreator;
        }

        var feedback = Feedback.builder()
                .author(authorUser)
                .receiver(receiverUser)
                .meet(meet)
                .socialBasic(getPercentage(request.getListOfBasicCompetence()))
                .socialAdvanced(getPercentage(request.getListOfAdvancedCompetence()))
                .build();

        feedbackRepository.saveAndFlush(feedback);
    }

    private Integer getPercentage(List<Integer> listOfCompetence) {
        var size = listOfCompetence.size();
        var sum = listOfCompetence.stream().mapToInt(note -> note).sum();
        return (sum/size);
    }

    private void validUsers(User userPartner, User userCreator) {
        if (Objects.isNull(userCreator) || Objects.isNull(userPartner)){
            throw new UserNotFoundException();
        }
    }

}
