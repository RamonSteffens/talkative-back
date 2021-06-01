package com.example.talkative1.entity.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLogedResponse {

    private Integer id;
    private String name;
    private String email;

}
