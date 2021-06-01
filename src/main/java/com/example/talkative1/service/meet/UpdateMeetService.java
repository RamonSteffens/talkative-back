package com.example.talkative1.service.meet;

import com.example.talkative1.entity.meet.Meet;
import com.example.talkative1.entity.meet.request.MeetUpdateActiveRequest;
import com.example.talkative1.entity.meet.request.MeetUpdateRequest;
import com.example.talkative1.repository.MeetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateMeetService {

    private final MeetRepository meetRepository;

    public void run(MeetUpdateRequest request) {
        var meet = getMeet(request.getMeetId());

        meet.ifPresent(meet1 -> {
            meet1.setMeetUrl(request.getMeetUrl());
            meetRepository.saveAndFlush(meet1);
        });
    }

    public void setActive(MeetUpdateActiveRequest meetUpdateActiveRequest){
        var meet = getMeet(meetUpdateActiveRequest.getMeetId());

        meet.ifPresent(meet1 -> {
            var isCreatorEnded = meetUpdateActiveRequest.getIsCreatorEnded();
            var isPartnerEnded = meetUpdateActiveRequest.getIsPartnerEnded();

            if (Objects.nonNull(isCreatorEnded) && isCreatorEnded){
                meet1.setIsCreatorEnded(true);
            }else if (Objects.nonNull(isPartnerEnded) && isPartnerEnded){
                meet1.setIsPartnerEnded(true);
            }

            var isEndedMeet = meet1.getIsCreatorEnded() && meet1.getIsPartnerEnded();
            if (isEndedMeet){
                meet1.setActive(false);
            }

            meetRepository.saveAndFlush(meet1);
        });
    }

    public Optional<Meet> getMeet(Integer id){
        return meetRepository.findById(id);
    }
}
