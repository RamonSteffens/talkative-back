package com.example.talkative1.entity.meet;

import com.example.talkative1.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String material;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    private LocalDate meetTime;

    private String meetUrl;

    private Boolean active;

    private Boolean isCreatorEnded;

    private Boolean isPartnerEnded;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User userCreator;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User userPartner;
}
