package com.example.talkative1.entity.feedback.response;

import com.example.talkative1.entity.feedback.Feedback;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponse {

    private Integer id;
    private Integer meetId;
    private String authorName;
    private String receiverName;
    private Integer socialBasic;
    private Integer socialAdvanced;

    public static FeedbackResponse build(Feedback feedback) {
        return FeedbackResponse.builder()
                .id(feedback.getId())
                .authorName(feedback.getAuthor().getName())
                .receiverName(feedback.getReceiver().getName())
                .socialBasic(feedback.getSocialBasic())
                .socialAdvanced(feedback.getSocialAdvanced())
                .meetId(feedback.getMeet().getId())
                .build();
    }
}
