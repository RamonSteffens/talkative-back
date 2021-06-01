package com.example.talkative1.service.feeling;

import com.example.talkative1.entity.feeling.Feeling;
import com.example.talkative1.entity.feeling.response.FeelingResponse;
import com.example.talkative1.entity.feeling.request.FeelingRequest;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.FeelingRepository;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RegisterFeelingService {

    private final FeelingRepository feelingRepository;
    private final UserRepository userRepository;

    public FeelingResponse run(FeelingRequest feelingRequest) {
        var user = userRepository.findById(feelingRequest.getUserId()).orElseThrow(UserNotFoundException::new);

        if (Objects.isNull(user)) {
            throw new UserNotFoundException();
        }

        var feeling = Feeling
                .builder()
                .feeling(feelingRequest.getFeeling())
                .user(user)
                .build();

        feelingRepository.saveAndFlush(feeling);

        return FeelingResponse.build(feeling);
    }

}
