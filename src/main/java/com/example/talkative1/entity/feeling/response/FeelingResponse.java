package com.example.talkative1.entity.feeling.response;

import com.example.talkative1.entity.feeling.Feeling;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FeelingResponse {

    private String feeling;

    private Integer userId;

    private LocalDateTime createdDate;

    public static FeelingResponse build(Feeling feeling) {
        return FeelingResponse.builder()
                .feeling(feeling.getFeeling())
                .userId(feeling.getUser().getId())
                .createdDate(feeling.getCreationTimestamp())
                .build();
    }
}
