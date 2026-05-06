package com.profile.controller;

import com.profile.dto.ApiResponse;
import com.profile.model.Experience;
import com.profile.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Experience>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(experienceService.getAllExperiences()));
    }
}