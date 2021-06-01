package com.example.talkative1.entity.feedback.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFeedbackRequest {

    private Integer meetId;
    private Integer authorId;

    private List<Integer> listOfBasicCompetence; //[0,1,1,1,0]; socialBasic -- 60%
    private List<Integer> listOfAdvancedCompetence; //[1,1,1,1,0]; socialAdvanced -- 80%
    //private Integer sentimental;
    //private Integer lidarComStress;

}
