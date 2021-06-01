package com.example.talkative1.entity.feeling.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeelingRequest {

    private String feeling;
    private Integer userId;

}
