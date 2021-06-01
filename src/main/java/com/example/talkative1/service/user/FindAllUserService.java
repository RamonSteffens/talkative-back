package com.example.talkative1.service.user;


import com.example.talkative1.entity.user.response.UserResponse;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllUserService {

    private final UserRepository userRepository;

    public List<UserResponse> run() {
        var users = userRepository.findAll();
        var usersResponse = new ArrayList<UserResponse>();

        users.forEach(user -> usersResponse.add(UserResponse.buildUser(user)));

        return usersResponse;
    }
}
