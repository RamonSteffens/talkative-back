package com.example.talkative1.entity.user;

import com.example.talkative1.entity.meet.Meet;
import com.example.talkative1.entity.feeling.Feeling;
import com.example.talkative1.entity.material.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Material> materials;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Feeling> feelings;

    @OneToMany(mappedBy = "userCreator", cascade = CascadeType.ALL)
    private List<Meet> meetCreator;

    @OneToMany(mappedBy = "userPartner", cascade = CascadeType.ALL)
    private List<Meet> meetPartner;
}
