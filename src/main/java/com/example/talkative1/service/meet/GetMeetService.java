package com.example.talkative1.service.meet;

import com.example.talkative1.entity.meet.Meet;
import com.example.talkative1.entity.meet.response.MeetResponse;
import com.example.talkative1.exception.meet.MeetNotFoundException;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.MeetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMeetService {

    private final MeetRepository meetRepository;

    public List<MeetResponse> findAllActive() {
        var meets = meetRepository.findAllByActiveTrue();
        var meetResponse = new ArrayList<MeetResponse>();

        meets.forEach(meet -> meetResponse.add(MeetResponse.build(meet)));

        return meetResponse;
    }

    public Meet findById(Integer meetId){
        return meetRepository.findById(meetId).orElseThrow(MeetNotFoundException::new);
    }
}
