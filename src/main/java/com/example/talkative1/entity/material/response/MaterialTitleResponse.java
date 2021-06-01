package com.example.talkative1.entity.material.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaterialTitleResponse {

    private Integer id;

    private String title;
}
