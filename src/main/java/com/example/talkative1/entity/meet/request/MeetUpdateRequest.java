package com.example.talkative1.entity.meet.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetUpdateRequest {

    private String meetUrl;
    private Integer meetId;

}
