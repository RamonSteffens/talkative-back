package com.example.talkative1.service.user;

import com.example.talkative1.entity.user.User;
import com.example.talkative1.entity.user.request.UserRequest;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserRepository repository;

    public User run(final Integer id, final UserRequest request) {

        var user = repository.findById(id).orElseThrow(UserNotFoundException::new);

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return repository.save(user);
    }
}
