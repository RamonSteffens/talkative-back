package com.example.talkative1.exception.meet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MeetNotFoundException extends RuntimeException {

    public MeetNotFoundException() {
        super("A reunião solicitada não foi encontrada.");
    }
}