package com.example.talkative1.entity.meet.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinMeetResponse {

    private String meetUrl;
    private Integer meetId;

}
