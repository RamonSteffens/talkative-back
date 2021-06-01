package com.example.talkative1.service.user;

import com.example.talkative1.entity.user.User;
import com.example.talkative1.entity.user.request.UserRequest;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;

    @Transactional
    public void run(UserRequest userRequest){

        var user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();

        userRepository.saveAndFlush(user);
    }

}
