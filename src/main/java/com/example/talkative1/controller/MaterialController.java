package com.example.talkative1.controller;

import com.example.talkative1.entity.material.response.MaterialResponse;
import com.example.talkative1.entity.material.request.MaterialRequest;
import com.example.talkative1.entity.material.response.MaterialTitleResponse;
import com.example.talkative1.service.material.CreateMaterialService;
import com.example.talkative1.service.material.GetMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/material")
@RequiredArgsConstructor
public class MaterialController {

    private final CreateMaterialService createMaterialService;
    private final GetMaterialService getMaterialService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private ResponseEntity<MaterialResponse> save(@RequestBody final MaterialRequest request) {
        return ResponseEntity.ok(createMaterialService.run(request));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping
    private ResponseEntity<List<MaterialResponse>> get() {
        return ResponseEntity.ok(getMaterialService.getAll());
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{id}")
    private ResponseEntity<MaterialResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(getMaterialService.getById(id));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/title")
    private ResponseEntity<List<MaterialTitleResponse>> getAllTitle() {
        return ResponseEntity.ok(getMaterialService.getAllTitle());
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/topic")
    private ResponseEntity<List<MaterialResponse>> getByTopic(@RequestParam String topic) {
        return ResponseEntity.ok(getMaterialService.getByTopic(topic));
    }
}
