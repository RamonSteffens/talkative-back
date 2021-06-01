package com.example.talkative1.service.meet;

import com.example.talkative1.entity.meet.request.JoinMeetRequest;
import com.example.talkative1.entity.meet.response.JoinMeetResponse;
import com.example.talkative1.repository.MeetRepository;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinMeetService {

    private final MeetRepository meetRepository;
    private final UserRepository userRepository;

    public JoinMeetResponse run(JoinMeetRequest request){
        var meet = meetRepository.findById(request.getMeetId());
        var partner = userRepository.findById(request.getUserPartnerId());
        var joinMeetResponse = JoinMeetResponse.builder();

        partner.ifPresent(user ->
                meet.ifPresent(meet1 -> {
                    meet1.setUserPartner(user);
                    meetRepository.saveAndFlush(meet1);
                    joinMeetResponse.meetUrl(meet1.getMeetUrl());
                }));

        return joinMeetResponse.build();
    }

}
