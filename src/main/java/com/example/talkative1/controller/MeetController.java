package com.example.talkative1.controller;

import com.example.talkative1.entity.meet.request.JoinMeetRequest;
import com.example.talkative1.entity.meet.request.MeetCreateRequest;
import com.example.talkative1.entity.meet.request.MeetUpdateActiveRequest;
import com.example.talkative1.entity.meet.request.MeetUpdateRequest;
import com.example.talkative1.entity.meet.response.JoinMeetResponse;
import com.example.talkative1.entity.meet.response.MeetResponse;
import com.example.talkative1.service.meet.CreateMeetService;
import com.example.talkative1.service.meet.GetMeetService;
import com.example.talkative1.service.meet.JoinMeetService;
import com.example.talkative1.service.meet.UpdateMeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meet")
@RequiredArgsConstructor
public class MeetController {

    private final CreateMeetService createMeetService;
    private final UpdateMeetService updateMeetService;
    private final GetMeetService getMeetService;
    private final JoinMeetService joinMeetService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody final MeetCreateRequest request) {
        createMeetService.run(request);
    }

    @GetMapping("/active")
    public ResponseEntity<List<MeetResponse>> getActiveMeets() {
        return ResponseEntity.ok(getMeetService.findAllActive());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/update")
    public void updateMeet(@RequestBody MeetUpdateRequest request) {
        updateMeetService.run(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/join")
    public JoinMeetResponse joinMeet(@RequestBody JoinMeetRequest request) {
        return joinMeetService.run(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/end")
    public void endMeet(@RequestBody MeetUpdateActiveRequest request) {
        updateMeetService.setActive(request);
    }


}
