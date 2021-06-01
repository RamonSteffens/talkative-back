package com.example.talkative1.service.meet;

import com.example.talkative1.entity.meet.Meet;
import com.example.talkative1.entity.meet.request.MeetCreateRequest;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.MeetRepository;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMeetService {

    private final MeetRepository meetRepository;

    private final UserRepository userRepository;


    public void run(MeetCreateRequest request) {

        var meet = Meet.builder()
                .name(request.getName())
                .material(request.getMaterial())
                .meetTime(request.getMeetTime())
                .isCreatorEnded(false)
                .isPartnerEnded(false)
                .active(true);

        var user = userRepository.findById(request.getUserCreatorId());

        user.ifPresent(meet::userCreator);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        meetRepository.saveAndFlush(meet.build());
    }
}
