package com.example.talkative1.entity.material.response;

import com.example.talkative1.entity.material.Material;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaterialResponse {

    private Integer id;

    private String title;

    private String content;

    private String author;

    private String topic;

    private Integer userId;

    public static MaterialResponse build(Material material){
        return MaterialResponse.builder()
                .id(material.getId())
                .author(material.getAuthor())
                .content(material.getContent())
                .title(material.getTitle())
                .topic(material.getTopic())
                .userId(material.getUser().getId())
                .build();
    }
}
