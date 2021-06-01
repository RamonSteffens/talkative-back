package com.example.talkative1.controller;

import com.example.talkative1.entity.feeling.response.FeelingResponse;
import com.example.talkative1.entity.feeling.request.FeelingRequest;
import com.example.talkative1.service.feeling.RegisterFeelingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeelingController {

    private final RegisterFeelingService registerFeelingService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/feeling")
    private ResponseEntity<FeelingResponse> save(@RequestBody final FeelingRequest request) {
        return ResponseEntity.ok(registerFeelingService.run(request));
    }

}
