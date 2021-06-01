package com.example.talkative1.service.user;

import com.example.talkative1.entity.user.response.UserLogedResponse;
import com.example.talkative1.entity.user.request.UserLoginRequest;
import com.example.talkative1.exception.user.InvalidPassException;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserService {

    private final UserRepository userRepository;

    public UserLogedResponse run(UserLoginRequest userRequest){
        var email = userRequest.getEmail();
        var pass = userRequest.getPassword();

        var user = userRepository.findByEmail(email);
        if (user.isPresent()){
            var realUser = user.get();
            var realPass = realUser.getPassword();
            if (realPass.equals(pass)){
                return UserLogedResponse.builder()
                        .id(realUser.getId())
                        .email(email)
                        .name(realUser.getName())
                        .build();
            }else{
                throw new InvalidPassException();
            }
        }else{
            throw new UserNotFoundException();
        }
    }
}
