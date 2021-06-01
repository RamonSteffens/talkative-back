package com.example.talkative1.entity.feedback;

import com.example.talkative1.entity.meet.Meet;
import com.example.talkative1.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer socialBasic;

    private Integer socialAdvanced;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Meet meet;
}
