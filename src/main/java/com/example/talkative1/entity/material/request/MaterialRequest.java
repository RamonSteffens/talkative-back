package com.example.talkative1.entity.material.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialRequest {

    private String title;

    private String content;

    private String topic;

    private Integer userId;
}
