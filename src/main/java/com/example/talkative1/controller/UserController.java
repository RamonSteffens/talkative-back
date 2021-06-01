package com.example.talkative1.controller;

import com.example.talkative1.entity.user.request.UserLoginRequest;
import com.example.talkative1.entity.user.request.UserRequest;
import com.example.talkative1.entity.user.response.UserLogedResponse;
import com.example.talkative1.entity.user.response.UserResponse;
import com.example.talkative1.service.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService createUserService;
    private final UpdateUserService updateUserService;
    private final GetUserService getUserService;
    private final FindAllUserService findAllUserService;
    private final LoginUserService loginUserService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    private void save(@RequestBody final UserRequest request) {
        createUserService.run(request);
    }

    @GetMapping("/user")
    private ResponseEntity<List<UserResponse>> get() {
        return ResponseEntity.ok(findAllUserService.run());
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<UserResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(getUserService.findById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/{id}")
    private void update(@PathVariable("id") final Integer id,
                        @RequestBody final UserRequest request) {

        updateUserService.run(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/user/login")
    public ResponseEntity<UserLogedResponse> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(loginUserService.run(request));
    }


}
