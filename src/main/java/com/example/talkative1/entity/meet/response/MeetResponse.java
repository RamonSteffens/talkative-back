package com.example.talkative1.entity.meet.response;

import com.example.talkative1.entity.meet.Meet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetResponse {

    private Integer id;

    private String name;

    private String material;

    private LocalDate meetTime;

    private Integer userCreatorId;

    private Integer userPartnerId;


    public static MeetResponse build(Meet meet) {
        var meetResponse = MeetResponse.builder()
                .id(meet.getId())
                .name(meet.getName())
                .meetTime(meet.getMeetTime())
                .userCreatorId(meet.getUserCreator().getId())
                .material(meet.getMaterial());

        var partner = meet.getUserPartner();

        if (Objects.nonNull(partner)) {
            meetResponse.userPartnerId(partner.getId());
        }

        return meetResponse.build();
    }
}
