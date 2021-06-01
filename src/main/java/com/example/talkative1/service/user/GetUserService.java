package com.example.talkative1.service.user;

import com.example.talkative1.entity.user.response.UserResponse;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserService {

    private final UserRepository userRepository;

    public UserResponse findById(final Integer id) {
        var user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return UserResponse.buildUser(user);
    }
}
