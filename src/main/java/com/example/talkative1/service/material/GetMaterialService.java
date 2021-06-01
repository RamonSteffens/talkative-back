package com.example.talkative1.service.material;

import com.example.talkative1.entity.material.response.MaterialResponse;
import com.example.talkative1.entity.material.response.MaterialTitleResponse;
import com.example.talkative1.exception.material.MaterialNotFoundException;
import com.example.talkative1.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMaterialService {

    private final MaterialRepository materialRepository;

    public MaterialResponse getById(Integer id) {
        var material = materialRepository.findById(id).orElseThrow(MaterialNotFoundException::new);
        return MaterialResponse.build(material);
    }

    public List<MaterialResponse> getByTopic(String topic) {
        var materials = materialRepository.findByTopic(topic);
        var materialsResponse = new ArrayList<MaterialResponse>();

        materials.forEach(material -> materialsResponse.add(MaterialResponse.build(material)));

        return materialsResponse;
    }

    public MaterialResponse getByTitle(String title) {
        var material = materialRepository.findByTitle(title).orElseThrow(MaterialNotFoundException::new);
        return MaterialResponse.build(material);
     }

    public List<MaterialResponse> getAll() {
        var materials = materialRepository.findAll();

        var materialsResponse = new ArrayList<MaterialResponse>();

        materials.forEach(material -> materialsResponse.add(MaterialResponse.build(material)));

        return materialsResponse;
    }

    public List<MaterialTitleResponse> getAllTitle() {
        return materialRepository.findAllMaterialNames();
    }



}
