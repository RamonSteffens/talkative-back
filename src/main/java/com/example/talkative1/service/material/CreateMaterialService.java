package com.example.talkative1.service.material;

import com.example.talkative1.entity.material.Material;
import com.example.talkative1.entity.material.response.MaterialResponse;
import com.example.talkative1.entity.material.request.MaterialRequest;
import com.example.talkative1.exception.user.UserNotFoundException;
import com.example.talkative1.repository.MaterialRepository;
import com.example.talkative1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMaterialService {

    private final MaterialRepository materialRepository;
    private final UserRepository userRepository;

    public MaterialResponse run(MaterialRequest materialRequest) {

        var userId = materialRequest.getUserId();

        var user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        var material = Material
                .builder()
                .title(materialRequest.getTitle())
                .author(user.getName())
                .content(materialRequest.getContent())
                .topic(materialRequest.getTopic())
                .user(user)
                .build();

        materialRepository.saveAndFlush(material);

        return MaterialResponse.build(material);
    }

}
